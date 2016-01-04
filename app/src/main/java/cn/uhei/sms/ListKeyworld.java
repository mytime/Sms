package cn.uhei.sms;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class ListKeyworld extends ListActivity {

    private List<ContentBean> contents = new ArrayList<ContentBean>();
    private KeyworldAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_keyworld);

        adapter = new KeyworldAdapter(this,contents);
        setListAdapter(adapter);

        //刷新
        setContentsData();

    }


    //刷新
    private void setContentsData() {
        List<ContentBean> contentData = ContentManager.getKeyworld(this);
        contents.clear();
        contents.addAll(contentData);
        adapter.notifyDataSetChanged();
    }

    public void btnAddKeyworld(View v){
        v = View.inflate(this, R.layout.dialog_add_phone, null);
        final EditText etPhone = (EditText) v.findViewById(R.id.etPhone);

        new AlertDialog.Builder(this)
                .setTitle("添加号码")
                .setView(v)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ContentBean content = new ContentBean();
                        content.setKeyworld(etPhone.getText() + "");

                        ContentManager.addKeyworld(ListKeyworld.this, content);
                        //刷新
                        setContentsData();
                    }
                })
                .setNegativeButton("取消", null)
                .show();

    }
}
