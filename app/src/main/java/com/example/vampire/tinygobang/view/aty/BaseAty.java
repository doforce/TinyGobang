package com.example.vampire.tinygobang.view.aty;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.vampire.tinygobang.R;

/**
 * Created by edgar on 16-5-31.
 */
public abstract class BaseAty extends FragmentActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_base);

        FragmentManager fm=getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.base_frag_container);

        if (fragment==null){
            fragment=createFragment();
            FragmentTransaction transaction=fm.beginTransaction();
            transaction.add(R.id.base_frag_container,fragment);
            transaction.commit();
        }
    }

    protected abstract Fragment createFragment();
}
