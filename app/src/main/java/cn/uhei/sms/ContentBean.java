package cn.uhei.sms;

import android.widget.EditText;

/**
 * 模型
 * 号码 关键词类
 */
public class ContentBean {
    private String number;
    private String keyworld;
    private String content;
    private String date;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
