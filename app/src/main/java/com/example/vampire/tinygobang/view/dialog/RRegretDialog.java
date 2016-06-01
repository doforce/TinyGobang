package com.example.vampire.tinygobang.view.dialog;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.vampire.tinygobang.R;
import com.example.vampire.tinygobang.util.mdButton.ButtonRectangle;

/**
 * Created by edgar on 16-6-1.
 */
public class RRegretDialog {
    public static AlertDialog dialog;
    public static Window window;
    public static ButtonRectangle agree;
    public static ButtonRectangle disagree;
    public static TextView textView;

    public static void init(Context context){
        dialog=new AlertDialog.Builder(context).create();
        dialog.setCancelable(false);
        window=dialog.getWindow();
        dialog.show();
        window.setContentView(R.layout.dialog_request_restart);

        textView= (TextView) window.findViewById(R.id.tv_request);
        textView.setText(context.getString(R.string.request_regret));

        agree= (com.example.vampire.tinygobang.util.mdButton.ButtonRectangle) window.findViewById(R.id.btn_agree);
        disagree= (com.example.vampire.tinygobang.util.mdButton.ButtonRectangle) window.findViewById(R.id.btn_disagree);
        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        disagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
