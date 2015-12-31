package cn.uhei.sms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddPhone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phone);
        
    }
    public void AddPhone(View view){
        try {
            System.out.println("添加电话");
        } catch (Exception e) {
            e.printStackTrace();e.printStackTrace();
        }
    }
}
