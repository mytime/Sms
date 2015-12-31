package cn.uhei.sms;

/**
 * 短信类
 */
public class SmsBean {
    private String Phone;
    private String Keyworld;

    public SmsBean(String phone, String keyworld) {
        Phone = phone;
        Keyworld = keyworld;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getKeyworld() {
        return Keyworld;
    }

    public void setKeyworld(String keyworld) {
        Keyworld = keyworld;
    }

    @Override
    public String toString() {
        return "SmsBean{" +
                "Phone='" + Phone + '\'' +
                ", Keyworld='" + Keyworld + '\'' +
                '}';
    }
}
