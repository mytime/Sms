package cn.uhei.sms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制器
 * 号码 关键词 处理方法
 */
public class ContentManager {

    private static Cursor c;
    private static SQLiteDatabase dbRead, dbWrite;
    private static SMSDatabase db;
    private static ContentBean contentBean;

    /**
     * 关键词 查询
     */

    public static List<ContentBean> getKeyworld(Context context) {
        List<ContentBean> contacts = new ArrayList<ContentBean>();

        //定义数据库对象并实例化
        db = new SMSDatabase(context);
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

    /**
     * 关键词 添加
     */

    public static void addKeyworld(Context context, ContentBean content) {
        db = new SMSDatabase(context);
        dbWrite = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("keyworld", content.getKeyworld());
        dbWrite.insert("keyworld", null, values);
        dbWrite.close();
    }

    /**
     * 关键词 删除
     */

    public static void deleteKeyworld(Context context, String i) {
        db = new SMSDatabase(context);
        dbWrite = db.getWritableDatabase();
        dbWrite.delete("keyworld", "keyworld=?", new String[]{i});
    }


    /**
     * 号码 查询
     */
    public static List<ContentBean> getContent(Context context) {
        List<ContentBean> contacts = new ArrayList<ContentBean>();

        //定义数据库对象并实例化
        db = new SMSDatabase(context);
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

    /**
     * 号码 添加
     */

    public static void addPhone(Context context, ContentBean content) {
        db = new SMSDatabase(context);
        dbWrite = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("phone", content.getNumber());
        dbWrite.insert("phone", null, values);
        dbWrite.close();
    }

    /**
     * 号码 删除
     */

    public static void deletePhone(Context context, String i) {
        db = new SMSDatabase(context);
        dbWrite = db.getWritableDatabase();
        dbWrite.delete("phone", "phone=?", new String[]{i});

    }

    /**
     * 内容 查询
     */
    public static List<ContentBean> getContentAll(Context context) {

        List<ContentBean> contacts = new ArrayList<ContentBean>();

        //定义数据库对象并实例化
        db = new SMSDatabase(context);
        //获取一个可读数据库
        dbRead = db.getReadableDatabase();

        //查询mcontent表
        c = null;
        c = dbRead.query("mcontent", null, null, null, null, null, null, null);
        contentBean = null;
        while (c.moveToNext()) {
            String phone = c.getString(c.getColumnIndex("phone"));
            String content = c.getString(c.getColumnIndex("content"));
            String date = c.getString(c.getColumnIndex("date"));

            contentBean = new ContentBean();
            contentBean.setContent(content);
            contentBean.setDate(date);
            contentBean.setNumber(phone);
            contacts.add(contentBean);
        }
        return contacts;
    }

    /**
     * 内容 插入
     */
    public static void addContent(Context context, ContentBean content) {
        db = new SMSDatabase(context);
        dbWrite = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("phone", content.getNumber());
        values.put("content", content.getContent());
        values.put("date", content.getDate());
        dbWrite.insert("mcontent", null, values);
        dbWrite.close();
    }

    /**
     * 内容删除
     */
    public static void deleteContentPhone(Context context, String i) {
        db = new SMSDatabase(context);
        dbWrite = db.getWritableDatabase();
        dbWrite.delete("mcontent", "phone = ?", new String[]{i});
    }


}
