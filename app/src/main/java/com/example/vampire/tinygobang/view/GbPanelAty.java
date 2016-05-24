package com.example.vampire.tinygobang.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vampire.tinygobang.R;
import com.example.vampire.tinygobang.dialog.ConnectModeDialog;
import com.example.vampire.tinygobang.dialog.ExitDialog;
import com.example.vampire.tinygobang.dialog.WForRestartDialog;

public class GbPanelAty extends Activity implements View.OnClickListener {
    public static TextView tvVictory;
    private Button btnRestart,btnExit;
    public static Button btnStart;
    private GbPanelView gbPanel;
    public static GbPanelAty gbPanelAty;
    boolean isWifiMode,isMachineMode,isHumanMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isWifiMode=getIntent().getStringExtra("flag").equals("wifi_match");
        isMachineMode=getIntent().getStringExtra("flag").equals("human_machine");
        isHumanMode=getIntent().getStringExtra("flag").equals("human");

        if (isHumanMode){
            setContentView(R.layout.gb_panel_hh);
        }else if (isMachineMode){
            setContentView(R.layout.gb_panel_hm);
        }else if (isWifiMode){
            setContentView(R.layout.gb_panel_wifi);
        }
        gbPanelAty=this;
        initView();
    }

    /**
     * 棋盘控件初始化
     */
    private void initView() {
        gbPanel= (GbPanelView) findViewById(R.id.view_gb_panel);
        tvVictory= (TextView) findViewById(R.id.tvVictory);
        btnRestart= (Button) findViewById(R.id.btnRestart);
        btnStart= (Button) findViewById(R.id.btnStart);
        btnExit= (Button) findViewById(R.id.btnExit);
        btnRestart.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRestart:
                if (isWifiMode){
                    WForRestartDialog.init(this);
                }
                gbPanel.deletePiece();
                GbPanelView.isGameOver=true;
                btnStart.setEnabled(true);
                break;
            case R.id.btnStart:
                gbPanel.deletePiece();
                GbPanelView.isGameOver=false;
                btnStart.setEnabled(false);
                break;
            case R.id.btnExit:
                if (isWifiMode){
                    ExitDialog.init(this);
                }
                if (isHumanMode || isMachineMode){
                    finish();
                }
                gbPanel.deletePiece();
                break;
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        if (isWifiMode){
        ConnectModeDialog.init(this);
        }
    }

}
