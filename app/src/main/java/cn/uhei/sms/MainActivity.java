package cn.uhei.sms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_MENU) {
            // 在这里做你想做的事情
            super.openOptionsMenu();  // 调用这个，就可以弹出菜单
        }
        ///最后，一定要做完以后返回 true，或者在弹出菜单后返回true，其他键返回super，让其他键默认
        return true;
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
    //在这里做你想做的事情
        super.onOptionsMenuClosed(menu);
    }

    //    然后是对menu菜单的配置，如下：

    @Override

    public void openOptionsMenu() {

        // TODO Auto-generated method stub

        super.openOptionsMenu();

    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        int group1 = 1;
        int gourp2 = 2;
        menu.add(group1, 1, 1, "item 11");
        menu.add(group1, 2, 2, "item 12");
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1: // do something here
                Log.i("MenuTest:", "ItemSelected:1");
                break;
            case 2: // do something here
                Log.i("MenuTest:", "ItemSelected:2");
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
