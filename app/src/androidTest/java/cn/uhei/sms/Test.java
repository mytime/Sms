package cn.uhei.sms;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

/**
 * Created by Administrator on 2016/1/4.
 */
public class Test extends AndroidTestCase {
    private ContentValues values;
    private SmsDb db;
    private SQLiteDatabase dbWrite,dbRead;
    public void test(){

        db = new SmsDb(getContext());
        dbWrite = db.getWritableDatabase();

        values = new ContentValues();
        values.put("keyworld", "2000");
        dbWrite.insert("keyworld",null,values);

        dbWrite.close();

    }
}
