package cn.uhei.sms;

import android.test.AndroidTestCase;

/**
 * Created by Administrator on 2016/1/3.
 */
public class Test extends AndroidTestCase {
    public void text(){
        ContentManager contentManager = new ContentManager();
        System.out.println(contentManager.getContent(getContext()).toString());
    }
}
