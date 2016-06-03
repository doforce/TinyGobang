package com.example.vampire.tinygobang.view.frag;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vampire.tinygobang.R;
import com.example.vampire.tinygobang.util.DrawBoard;
import com.example.vampire.tinygobang.util.mdButton.ButtonRectangle;

/**
 * Created by edgar on 16-5-31.
 */
public class GameFrag extends Fragment implements View.OnClickListener{
    public  TextView tvVictory;
    private ButtonRectangle btnRestart;
    private ButtonRectangle btnExit;
    public ButtonRectangle btnStart;
    public static GameFrag mGameFrag;
//    private NetDialog mNetDialog;

//    public void setmNetDialog(NetDialog mNetDialog) {
//        this.mNetDialog = mNetDialog;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_game,container,false);
        mGameFrag =this;
        initView(view);
        return view;
    }

        /**
     * 棋盘控件初始化
     */
    private void initView(View view) {
        tvVictory= (TextView) view.findViewById(R.id.tvVictory);
        btnRestart= (com.example.vampire.tinygobang.util.mdButton.ButtonRectangle) view.findViewById(R.id.btn_regret);
        btnStart= (com.example.vampire.tinygobang.util.mdButton.ButtonRectangle) view.findViewById(R.id.btn_start);
        btnExit= (com.example.vampire.tinygobang.util.mdButton.ButtonRectangle) view.findViewById(R.id.btn_exit);
        btnRestart.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }



    private void startGame(){
        if (btnStart.getText().equals(getString(R.string.start_game))){
            DrawBoard.getInstance().deletePiece();
            DrawBoard.getInstance().isGameOver=false;
            btnStart.setText(getString(R.string.restart_game));
        }else if(btnStart.getText().equals(getString(R.string.restart_game))){
            DrawBoard.getInstance().deletePiece();
            DrawBoard.getInstance().isGameOver=false;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_regret:
//                mNetDialog.regretDialog();
                DrawBoard.getInstance().regret();
                break;
            case R.id.btn_start:
//                mNetDialog.startDialog();
                startGame();
                break;
            case R.id.btn_exit:
//                mNetDialog.exitDialog();
                getActivity().finish();
                DrawBoard.getInstance().deletePiece();
                break;
        }
    }

//    @Override
//    public LinkedList<Point> putWhiteChess(LinkedList<Point> white, Point point) {
//        white.add(point);
//        return white;
//    }
//
//    @Override
//    public LinkedList<Point> putBlackChess(LinkedList<Point> black, Point point) {
//        black.add(point);
//        return black;
//    }

//    public interface NetDialog{
//        void regretDialog();
//        void startDialog();
//        void exitDialog();
//    }

}
