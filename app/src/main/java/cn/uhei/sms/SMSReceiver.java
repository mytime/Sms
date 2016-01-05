package cn.uhei.sms;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * 短信接收
 * 使用BroadcastReceiver需要配置AndroidManifest.xml
 */
public class SMSReceiver extends BroadcastReceiver {
    SMSDatabase db;
    SQLiteDatabase dbRead,dbWrite;
    ContentBean contents;
    private String fromAddress;
    private String fromMessage;
    private String fromDate;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null)
            return;
        //获取单元对象
        Object[] pdus = (Object[]) extras.get("pdus");

        db = new SMSDatabase(context);
        dbRead = db.getReadableDatabase();

        for (int i = 0; i < pdus.length; i++) {

            SmsMessage message = SmsMessage.createFromPdu((byte[]) pdus[i]);
            //发送者手机号
            fromAddress = message.getOriginatingAddress();
            //接收到的内容
            fromMessage = message.getMessageBody();
            //接收时间
            fromDate = new Date(message.getTimestampMillis()).toLocaleString();

            /**
             * 号码拦截
             */

            Cursor c = dbRead.query("phone", new String[]{"phone"}, "phone=?", new String[]{fromAddress}, null, null, null);
            while (c.moveToNext()) {
                //获取号码
                String phone = c.getString(c.getColumnIndex("phone"));
                //拦截号码
                if (fromAddress.equals(phone)) {
                    //执行插入
                    setContentData(context);
                    
                    //阻止广播
                    abortBroadcast();

                }
            }

            /**
             * 内容拦截
             */
            c = null;
            c = dbRead.query("keyworld", null, null, null, null, null, null);
            while (c.moveToNext()) {
                String keyworld = c.getString(c.getColumnIndex("keyworld"));
                //内容是否包含某某关键词,true阻止广播
                if (fromMessage.contains(keyworld)) {
                    //执行插入
                    setContentData(context);

                    //阻止广播
                    abortBroadcast();
                }
            }

        }

    }

    /**
     * 插入方法
     */
    public void setContentData(Context context){
        db = new SMSDatabase(context);
        dbWrite = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("phone",fromAddress);
        values.put("content",fromMessage);
        values.put("date",fromDate);
        dbWrite.insert("mcontent",null,values);
    }

}
