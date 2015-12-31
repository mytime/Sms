package cn.uhei.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * 短信接收
 * 使用BroadcastReceiver需要配置AndroidManifest.xml
 */
public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //获取intent传过来的内容
        Bundle bundle = intent.getExtras();
        //提取短信
        Object[] pdus = (Object[]) bundle.get("pdus");
        // 构建短信对象数组；
        SmsMessage[] messages = new SmsMessage[pdus.length];
        for (int i = 0; i < messages.length; i++) {
            // 获取单条短信内容，以pdu格式存,并生成短信对象；
            messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
        }
        //获取发送方号码
        String address = messages[0].getOriginatingAddress();
        String fullMessage = "";
        for (SmsMessage message : messages) {
            //获取短信内容
            fullMessage += message.getMessageBody();
        }
        System.out.println(">>>>>>>>>>>>>" + address + fullMessage);


    }
}
