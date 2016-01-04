package cn.uhei.sms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/3.
 */
public class ContentManager {

    private static Cursor c;
    private static SQLiteDatabase dbRead, dbWrite;
    private static SmsDb db;
    private static ContentBean contentBean;

    //查询关键词
    public static List<ContentBean> getKeyworld(Context context) {
        List<ContentBean> contacts = new ArrayList<ContentBean>();

        //定义数据库对象并实例化
        db = new SmsDb(context);
        //获取一个可读数据库
        dbRead = db.getReadableDatabase();

        //查询keyworld表
        c = null;
        c = dbRead.query("keyworld", null, null, null, null, null, null, null);
        contentBean = null;
        while (c.moveToNext()) {
            String keyworld = c.getString(c.getColumnIndex("keyworld"));
            contentBean = new ContentBean();
            contentBean.setKeyworld(keyworld);
            contacts.add(contentBean);
        }

        return contacts;
    }

    //添加关键词
    public static void addKeyworld(Context context, ContentBean content) {
        db = new SmsDb(context);
        dbWrite = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("keyworld", content.getKeyworld());
        dbWrite.insert("keyworld", null, values);
        dbWrite.close();
    }


    //查询号码
    public static List<ContentBean> getContent(Context context) {
        List<ContentBean> contacts = new ArrayList<ContentBean>();

        //定义数据库对象并实例化
        db = new SmsDb(context);
        //获取一个可读数据库
        dbRead = db.getReadableDatabase();

        //查询phone表
        c = null;
        c = dbRead.query("phone", null, null, null, null, null, null, null);

        while (c.moveToNext()) {
            String number = c.getString(c.getColumnIndex("phone"));
            contentBean = new ContentBean();
            contentBean.setNumber(number);
            contacts.add(contentBean);
        }
        dbRead.close();
        return contacts;
    }

    //添加号码
    public static void addPhone(Context context, ContentBean content) {
        db = new SmsDb(context);
        dbWrite = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("phone", content.getNumber());
        dbWrite.insert("phone", null, values);
        dbWrite.close();
    }

    //删除
    public static void deletePhone(Context context, String i) {
        db = new SmsDb(context);
        dbWrite = db.getWritableDatabase();
        dbWrite.delete("phone", "phone=?", new String[]{i});
    }

}
