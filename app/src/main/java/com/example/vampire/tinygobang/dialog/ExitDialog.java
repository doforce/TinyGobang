package com.example.vampire.tinygobang.dialog;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.vampire.tinygobang.R;
import com.example.vampire.tinygobang.view.GbPanelAty;

/**
 * Created by X on 2016/4/23 0023.
 * WiFi连接下棋是点退出游戏按钮时弹出的对话框类
 */
public class ExitDialog {
    public static AlertDialog dialog;
    public static Window window;
    public static Button exit,cancel;

    public static void init(Context context){
        dialog=new AlertDialog.Builder(context).create();
        dialog.setCancelable(false);
        window=dialog.getWindow();
        dialog.show();
        window.setContentView(R.layout.dialog_exit);

        exit= (Button) window.findViewById(R.id.exit_yes);
        cancel= (Button) window.findViewById(R.id.exit_cancel);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GbPanelAty.gbPanelAty.finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
