package com.example.vampire.tinygobang.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vampire.tinygobang.R;
import com.example.vampire.tinygobang.dialog.ConnectModeDialog;
import com.example.vampire.tinygobang.dialog.ExitDialog;
import com.example.vampire.tinygobang.dialog.WForRestartDialog;
import com.example.vampire.tinygobang.util.DrawBoard;

public class GbPanelAty extends Activity implements View.OnClickListener {
    private static final String TAG = "GbPanelAty";
    public static TextView tvVictory;
    private Button btnRestart,btnExit;
    public static Button btnStart;
    public static GbPanelAty gbPanelAty;
    boolean isWifiMode,isMachineMode,isHumanMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isWifiMode=getIntent().getStringExtra("flag").equals("wifi_match");
        isMachineMode=getIntent().getStringExtra("flag").equals("human_machine");
        isHumanMode=getIntent().getStringExtra("flag").equals("human");

        setContentView(R.layout.gb_panel);
        initView();
    }

    /**
     * 棋盘控件初始化
     */
    private void initView() {
        tvVictory= (TextView) findViewById(R.id.tvVictory);
        btnRestart= (Button) findViewById(R.id.btn_regret);
        btnStart= (Button) findViewById(R.id.btn_start);
        btnExit= (Button) findViewById(R.id.btn_exit);
        btnRestart.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_regret:
                if (isWifiMode){
                    WForRestartDialog.init(this);
                }
                DrawBoard.getInstance().regret();
                break;
            case R.id.btn_start:
                startGame();
                break;
            case R.id.btn_exit:
                if (isWifiMode){
                    ExitDialog.init(this);
                }
                if (isHumanMode || isMachineMode){
                    finish();
                }
                DrawBoard.getInstance().deletePiece();
                break;
        }
    }

    private void startGame(){
        if (btnStart.getText().equals(getString(R.string.start_game))){
            DrawBoard.getInstance().deletePiece();
            DrawBoard.getInstance().isGameOver=false;
            Log.e(TAG, "onClick: "+btnStart.getText() );
            btnStart.setText(R.string.restart_game);
        }else if(btnStart.getText().equals(getString(R.string.restart_game))){
            DrawBoard.getInstance().deletePiece();
            DrawBoard.getInstance().isGameOver=false;
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
