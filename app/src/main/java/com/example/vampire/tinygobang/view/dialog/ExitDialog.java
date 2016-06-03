package com.example.vampire.tinygobang.view.dialog;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;

import com.example.vampire.tinygobang.R;
import com.example.vampire.tinygobang.util.mdButton.ButtonRectangle;
import com.example.vampire.tinygobang.view.frag.GameFrag;

/**
 * Created by X on 2016/4/23 0023.
 * WiFi连接下棋是点退出游戏按钮时弹出的对话框类
 */
public class ExitDialog {
    public static AlertDialog dialog;
    public static Window window;
    public static ButtonRectangle exit;
    public static ButtonRectangle cancel;

    public static void init(Context context){
        dialog=new AlertDialog.Builder(context).create();
        dialog.setCancelable(false);
        window=dialog.getWindow();
        dialog.show();
        window.setContentView(R.layout.dialog_exit);

        exit= (com.example.vampire.tinygobang.util.mdButton.ButtonRectangle) window.findViewById(R.id.exit_yes);
        cancel= (com.example.vampire.tinygobang.util.mdButton.ButtonRectangle) window.findViewById(R.id.exit_cancel);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameFrag.mGameFrag.getActivity().finish();
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
