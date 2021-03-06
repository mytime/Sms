package cn.uhei.sms;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * 拦截号码表 添加拦截号码
 */
public class ListPhone extends ListActivity {

    //列表
    private List<ContentBean> contents = new ArrayList<ContentBean>();
    private AdapterPhone adapter;

    /**
     * 长按删除方法
     */
    private AdapterView.OnItemLongClickListener listViewItemLongClickListener
            = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view,
                                       final int position, long id) {
            new AlertDialog
                    .Builder(ListPhone.this)
                    .setTitle("提醒")
                    .setMessage("您确定要删除该项吗")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                          //获取phone
                            ContentBean cb = adapter.getItem(position);
                            String i = cb.getNumber();
                            //执行删除
                            ContentManager.deletePhone(ListPhone.this, i);
                            //刷新
                            setContentsData();
                        }
                    })
                    .setNegativeButton("取消", null)
                    .show();
            return true;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_list);

        adapter = new AdapterPhone(this, contents);

        setListAdapter(adapter);

        //显示数据 刷新
        setContentsData();

        //长按删除
        getListView().setOnItemLongClickListener(listViewItemLongClickListener);
    }


    /**
     * 添加拦截号码
     * @param v
     */
    public void btnAddPhone(View v) {
        v = View.inflate(this, R.layout.dialog_add_content, null);
        final EditText etPhone = (EditText) v.findViewById(R.id.etPhone);

        new AlertDialog.Builder(this)
                .setTitle("添加号码")
                .setView(v)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ContentBean content = new ContentBean();
                        if (etPhone.getText().toString().length() != 0) {
                            content.setNumber(etPhone.getText()+"");
                            ContentManager.addPhone(ListPhone.this, content);
                            //刷新
                            setContentsData();
                        }
                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }

    /**
     * 刷新号码表
     */
    private void setContentsData() {
        List<ContentBean> contentData = ContentManager.getContent(this);
        contents.clear();
        contents.addAll(contentData);
        adapter.notifyDataSetChanged();
    }
}
