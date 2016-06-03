package com.example.vampire.tinygobang.view.dialog;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vampire.tinygobang.R;
import com.example.vampire.tinygobang.util.mdButton.ButtonRectangle;

import java.util.ArrayList;

/**
 * Created by X on 2016/4/23 0023.
 * 搜索附近玩家的对话框类
 */
public class JoinGameDialog {
    private static ButtonRectangle join_game_cancel;
    public static ArrayList<String> phoneName = new ArrayList<>(10);
    public static AlertDialog dialog;
    public static Window window;


    public static void init(Context context) {
        dialog = new AlertDialog.Builder(context).create();
        dialog.setCancelable(false);
        dialog.show();
        window = dialog.getWindow();
        window.setContentView(R.layout.dialog_join_game);

        join_game_cancel = (com.example.vampire.tinygobang.util.mdButton.ButtonRectangle) window.findViewById(R.id.join_game_cancel);
        join_game_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectModeDialog.isJoinGameBtnClicked=false;
                dialog.dismiss();
            }
        });

        listViewDisplay(context);
    }

    /**
     * 设置ListView
     * @param context
     */
    public static void listViewDisplay(Context context){
        ListView listView= (ListView) window.findViewById(R.id.join_game_listView);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(context,R.layout.dialog_cell,phoneName);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dialog.dismiss();
                ConnectModeDialog.dialog.dismiss();
            }
        });
    }

}