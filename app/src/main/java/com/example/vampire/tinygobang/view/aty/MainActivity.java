package com.example.vampire.tinygobang.view.aty;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.vampire.tinygobang.view.frag.MainFrag;

/**
 * Created by X on 2016/4/14 0014.
 */
public class MainActivity extends BaseAty  {
    private long firstBackTime;
    private static final String TAG = "MainActivity";

    @Override
    public void onBackPressed() {
        long secondBackTime = System.currentTimeMillis();
        if (secondBackTime - firstBackTime > 2000) {
            Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
            firstBackTime = secondBackTime;
        } else {
            finish();
        }
    }

    @Override
    protected Fragment createFragment() {
        return new MainFrag();
    }

}
