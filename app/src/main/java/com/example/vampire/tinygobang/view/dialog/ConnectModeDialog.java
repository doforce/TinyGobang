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
 * 选择连接模式的对话框的类
 */
public class ConnectModeDialog {

    public static ButtonRectangle btnCreateGame;
    public static ButtonRectangle btnJoinGame;
    public static ButtonRectangle btnCancel;
    public static AlertDialog dialog;
    public static Window window;

    //用于判断是主机创建主机还是对方创建主机
    public static boolean isCreateGameBtnClicked;
    public static boolean isJoinGameBtnClicked;

    public static void init(final Context context){
        dialog=new AlertDialog.Builder(context).create();
        dialog.setCancelable(false);

        dialog.show();
        window=dialog.getWindow();
        window.setContentView(R.layout.dialog_connect_option);

        btnCreateGame= (com.example.vampire.tinygobang.util.mdButton.ButtonRectangle) window.findViewById(R.id.btnCreateGame);
        btnJoinGame= (com.example.vampire.tinygobang.util.mdButton.ButtonRectangle) window.findViewById(R.id.btnJoinGame);
        btnCancel=  (com.example.vampire.tinygobang.util.mdButton.ButtonRectangle)window.findViewById(R.id.btnCancel);
        btnCreateGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCreateGameBtnClicked=true;
                CreateGameDialog.init(context);
            }
        });
        btnJoinGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isJoinGameBtnClicked=true;
                JoinGameDialog.init(context);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectModeDialog.isCreateGameBtnClicked=false;
                ConnectModeDialog.isJoinGameBtnClicked=false;
                dialog.dismiss();
                GameFrag.mGameFrag.getActivity().finish();
            }
        });
    }
}
