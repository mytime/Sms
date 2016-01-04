package cn.uhei.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * 短信接收
 * 使用BroadcastReceiver需要配置AndroidManifest.xml
 */
public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if(extras == null)
            return;

        Object[] pdus = (Object[]) extras.get("pdus");

        SmsDb db = new SmsDb(context);
        SQLiteDatabase dbRead = db.getReadableDatabase();

        for (int i = 0; i < pdus.length; i++) {



            SmsMessage message = SmsMessage.createFromPdu((byte[]) pdus[i]);
            //发送者手机号
            String fromAddress = message.getOriginatingAddress();

            //查询数据库
            Cursor c = dbRead.query("phone", new String[]{"phone"}, "phone=?", new String[]{fromAddress}, null, null, null);

            while (c.moveToNext()){
                String phone  = c.getString(c.getColumnIndex("phone"));
                if (fromAddress.equals(phone)){
                    abortBroadcast();
                }
            }

//            //短信内容
            String fromMessage = message.getMessageBody();
            //内容是否包含某某关键词
//            fromMessage.contains()

//            String fromDisplayName = fromAddress;

//            System.out.format("短信发送者:%s,信息内容：%s\n", fromAddress, fromMessage);

        }

    }
}
