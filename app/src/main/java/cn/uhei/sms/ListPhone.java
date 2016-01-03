package cn.uhei.sms;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ListPhone extends AppCompatActivity {

    private ListView lvPhone;
    //列表
    private List<ContentBean> contents = new ArrayList<ContentBean>();
    private ContentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_list);

        //填充列表
        lvPhone = (ListView) findViewById(R.id.lvPhone);

        adapter = new ContentAdapter(this, contents);
        lvPhone.setAdapter(adapter);
        setContentsData();


    }

    //添加
    public void btnAddPhone(View v) {
        v = View.inflate(this,R.layout.dialog_add_phone,null);
        final EditText etPhone = (EditText) v.findViewById(R.id.etPhone);

        new AlertDialog.Builder(this)
                .setTitle("添加号码")
                .setView(v)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ContentBean content = new ContentBean();
                        content.setNumber(etPhone.getText()+"");

                        ContentManager.addPhone(ListPhone.this,content);
                        //刷新
                        setContentsData();
                    }
                })
                .setNegativeButton("取消",null)
                .show();

    }

    //刷新
    private void setContentsData(){
        List<ContentBean> contentData = ContentManager.getContent(this);
        contents.clear();
        contents.addAll(contentData);
        adapter.notifyDataSetChanged();
    }
}
