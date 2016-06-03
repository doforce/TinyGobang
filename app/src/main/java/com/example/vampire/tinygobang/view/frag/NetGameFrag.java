package com.example.vampire.tinygobang.view.frag;

import com.example.vampire.tinygobang.view.dialog.ConnectModeDialog;

/**
 * Created by edgar on 16-5-31.
 */
public class NetGameFrag extends GameFrag  {
    @Override
    public void onResume() {
        super.onResume();
            ConnectModeDialog.init(getActivity());
    }

//    @Override
//    public void regretDialog() {
//
//    }
//
//    @Override
//    public void startDialog() {
//
//    }
//
//    @Override
//    public void exitDialog() {
//
//    }
}
