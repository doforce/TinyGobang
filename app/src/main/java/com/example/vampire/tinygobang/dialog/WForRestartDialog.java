package com.example.vampire.tinygobang.dialog;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.Window;

import com.example.vampire.tinygobang.R;

/**
 * Created by X on 2016/4/23 0023.
 * 等待对方是否同意重新开始的对话框类
 */
public class WForRestartDialog {
    public static AlertDialog dialog;
    public static Window window;
    public static void init(Context context){
        dialog=new AlertDialog.Builder(context).create();
//        dialog.setCancelable(false);
        window=dialog.getWindow();
        dialog.show();
        window.setContentView(R.layout.dialog_waitingfor_restart);
    }
}
