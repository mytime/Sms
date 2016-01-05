package cn.uhei.sms;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2015/12/31.
 */
public class SMSDatabase extends SQLiteOpenHelper {
    public SMSDatabase(Context context) {
//        定义数据库
        super(context, "msms.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    //创建拦截电话表
        db.execSQL("create table phone(_id integer primary key autoincrement," +
                "phone text default none)");
        //创建拦截关键字表
        db.execSQL("create table keyworld(_id integer primary key autoincrement," +
                "keyworld text default none)");
        //创建内容表
        db.execSQL("create table mcontent(_id integer primary key autoincrement," +
                "phone text default none," +
                "content text default none," +
                "date text default none)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
