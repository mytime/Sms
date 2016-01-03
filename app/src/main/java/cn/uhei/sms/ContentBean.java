package cn.uhei.sms;

import android.widget.EditText;

/**
 * Created by Administrator on 2016/1/3.
 */
public class ContentBean {
    private String number;
    private String keyworld;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getKeyworld() {
        return keyworld;
    }

    public void setKeyworld(String keyworld) {
        this.keyworld = keyworld;
    }

    @Override
    public String toString() {
        return "ContentBean{" +
                "number='" + number + '\'' +
                ", keyworld='" + keyworld + '\'' +
                '}';
    }

//    public ContentBean(String number, String keyworld) {
//        this.number = number;
//        this.keyworld = keyworld;
//    }
}
