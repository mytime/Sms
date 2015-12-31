package cn.uhei.sms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SetAty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_aty);
    }
    public void keyworld(View view){
        Intent intent = new Intent(this,AddKeyworld.class);
        startActivity(intent);
    }

    public void phone(View view){
        Intent intent = new Intent(this,AddPhone.class);
        startActivity(intent);
    }
}
