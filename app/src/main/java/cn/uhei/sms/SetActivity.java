package cn.uhei.sms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * 添加要拦截的号码和内容
 */
public class SetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
    }

    /**
     * 添加关键词
     * @param v
     */
    public void btnAddKeyworld(View v) {
        startActivity(new Intent(SetActivity.this,ListKeyworld.class));
    }

    /**
     * 添加号码
     * @param v
     */
    public void btnPhoneClick(View v) {
        startActivity(new Intent(SetActivity.this, ListPhone.class));
    }


}
