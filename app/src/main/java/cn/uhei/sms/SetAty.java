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

    public void btnAddKeyworld(View v) {
        startActivity(new Intent(SetAty.this,ListKeyworld.class));
    }

    public void btnPhoneClick(View v) {
        startActivity(new Intent(SetAty.this, ListPhone.class));
    }


}
