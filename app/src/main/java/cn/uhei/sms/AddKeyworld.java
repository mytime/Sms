package cn.uhei.sms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddKeyworld extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_keyworld);
    }
    public void AddKeyworld(View view){
        try {
            System.out.println("添加关键字");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
