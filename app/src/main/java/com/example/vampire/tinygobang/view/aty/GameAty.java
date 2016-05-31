package com.example.vampire.tinygobang.view.aty;

import android.support.v4.app.Fragment;

import com.example.vampire.tinygobang.view.frag.GameFrag;
import com.example.vampire.tinygobang.view.frag.MainFrag;
import com.example.vampire.tinygobang.view.frag.NetGameFrag;

public class GameAty extends BaseAty  {

    @Override
    protected Fragment createFragment() {
        int gameMode=getIntent().getIntExtra(MainFrag.FLAG,-1);
        Fragment fragment=null;
        switch (gameMode){
            case 1:
                fragment=new GameFrag();
                break;
            case 2:
                fragment=new GameFrag();
                break;
            case 3:
                fragment=new NetGameFrag();
                break;
        }
        return fragment;
    }

    @Override
    public void onBackPressed() {
    }
}
