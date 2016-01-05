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
 * 拦截关键词表 添加拦截关键词
 */
public class ListKeyworld extends ListActivity {

    private List<ContentBean> contents = new ArrayList<ContentBean>();
    private AdapterKeyworld adapter;

    /**
     * 长按删除方法
     */
    private AdapterView.OnItemLongClickListener listViewItemLongClickListener
            = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view,
                                       final int position, long id) {

            new AlertDialog
                    .Builder(ListKeyworld.this)
                    .setTitle("提醒")
                    .setMessage("您确定要删除该项吗")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                          //获取关键词
                            ContentBean cb = adapter.getItem(position);
                            String i = cb.getKeyworld();
                            //执行删除
                            ContentManager.deleteKeyworld(ListKeyworld.this, i);
                            //刷新
                            setContentsData();
                        }
                    })
                    .setNegativeButton("取消", null)
                    .show();
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_keyworld);

        adapter = new AdapterKeyworld(this,contents);
        setListAdapter(adapter);

        //显示数据 刷新
        setContentsData();

        //长按删除
        getListView().setOnItemLongClickListener(listViewItemLongClickListener);
    }


    /**
     * 添加拦截关键词
     * @param v
     */
    public void btnAddKeyworld(View v){
        v = View.inflate(this, R.layout.dialog_add_content, null);
        final EditText etPhone = (EditText) v.findViewById(R.id.etPhone);

        new AlertDialog.Builder(this)
                .setTitle("添加关键词")
                .setView(v)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ContentBean content = new ContentBean();
                        if (etPhone.getText().toString().length() != 0) {
                            content.setKeyworld(etPhone.getText() + "");
                            ContentManager.addKeyworld(ListKeyworld.this, content);
                            //刷新
                            setContentsData();
                        }
                    }
                })
                .setNegativeButton("取消", null)
                .show();

    }

    /**
     * 刷新关键词列表
     */
    private void setContentsData() {
        List<ContentBean> contentData = ContentManager.getKeyworld(this);
        contents.clear();
        contents.addAll(contentData);
        adapter.notifyDataSetChanged();
    }
}
