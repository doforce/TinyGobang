package com.example.vampire.tinygobang.view.dialog;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.Window;
import android.widget.TextView;

import com.example.vampire.tinygobang.R;

/**
 * Created by edgar on 16-6-1.
 */
public class WForRegretDialog {
    public static AlertDialog dialog;
    public static Window window;
    public static TextView textView;
    public static void init(Context context){
        dialog=new AlertDialog.Builder(context).create();
//        dialog.setCancelable(false);
        window=dialog.getWindow();
        dialog.show();
        window.setContentView(R.layout.dialog_waitingfor_restart);

        textView= (TextView) window.findViewById(R.id.tv_waiting);
        textView.setText(context.getString(R.string.waiting_for_regret));
    }

}
