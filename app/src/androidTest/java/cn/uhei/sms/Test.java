package cn.uhei.sms;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

/**
 * Created by Administrator on 2016/1/4.
 */
public class Test extends AndroidTestCase {
    private ContentValues values;
    private SMSDatabase db;
    private SQLiteDatabase dbWrite,dbRead;
    public void test(){

        db = new SMSDatabase(getContext());
        dbWrite = db.getWritableDatabase();

        values = new ContentValues();
        values.put("phone", "10086");
        values.put("content","abc");
        values.put("date","2016.2.2");
        dbWrite.insert("mcontent",null,values);
        dbWrite.close();

    }
}
