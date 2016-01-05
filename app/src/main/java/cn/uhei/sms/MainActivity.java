package cn.uhei.sms;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //列表
    private List<ContentBean> contents = new ArrayList<ContentBean>();
    private AdapterContent adapter;
    private ListView lv;

    //长按删除方法
    private AdapterView.OnItemLongClickListener listViewItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
            new AlertDialog
                    .Builder(MainActivity.this)
                    .setTitle("提醒")
                    .setMessage("您确定要删除该项吗")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                          //获取phone
//                            adapter.
                            ContentBean cb = adapter.getItem(position);

                            String i = cb.getNumber();
                            //执行删除
                            ContentManager.deleteContentPhone(MainActivity.this, i);
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
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.list);

        adapter = new AdapterContent(this, contents);
        lv.setAdapter(adapter);

        //长按删除
        lv.setOnItemLongClickListener(listViewItemLongClickListener);

        //显示数据
        setContentsData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //显示数据
        setContentsData();
    }

    /**
     * 刷新号码表
     */
    private void setContentsData() {
        List<ContentBean> contentData = ContentManager.getContentAll(this);
        contents.clear();
        contents.addAll(contentData);
        adapter.notifyDataSetChanged();
    }

    /**
     * 物理键事件
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_MENU) {
            super.openOptionsMenu();  // 启动菜单
        } else if (keyCode == KeyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(this)
                    .setTitle("退出")
                    .setMessage("确定退出吗？")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent exit = new Intent(Intent.ACTION_MAIN);
                            exit.addCategory(Intent.CATEGORY_HOME);
                            exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(exit);
                            System.exit(0);
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .show();
        }
        return true;
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    /**
     * 打开菜单
     */
    @Override
    public void openOptionsMenu() {
        super.openOptionsMenu();
    }

    /**
     * 创建菜单
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        int group1 = 1;
        menu.add(group1, 1, 1, "设置");
        return true;
    }

    /**
     * 点击菜单
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Intent intent = new Intent(MainActivity.this, SetActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
