package com.example.vampire.tinygobang.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.vampire.tinygobang.logic.JudgeWinner;
import com.example.vampire.tinygobang.R;
import com.example.vampire.tinygobang.util.DrawGb;

import java.util.LinkedList;

/**
 * Created by X on 2016/4/14 0014.
 */
public class GbPanelView extends View {
    public  static boolean isGameOver=true;
    private JudgeWinner judgeWinner;

    public static LinkedList<Point> mWhiteArray=new LinkedList<>();
    public static LinkedList<Point> mBlackArray=new LinkedList<>();


    public GbPanelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        judgeWinner=new JudgeWinner();
        DrawGb.getInstance().init();
        DrawGb.getInstance().mWhitePiece= BitmapFactory.decodeResource(getResources(), R.drawable.white);
        DrawGb.getInstance().mBlackPiece= BitmapFactory.decodeResource(getResources(),R.drawable.black);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);

        int heightSize=MeasureSpec.getSize(heightMeasureSpec);

        int width=Math.min(widthSize,heightSize);

        setMeasuredDimension(width,width);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        DrawGb.getInstance().sizeChanged(w);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (DrawGb.getInstance().touchEvent(event)){
            invalidate();

            return true;
        }
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        DrawGb.getInstance().drawBoard(canvas);
        DrawGb.getInstance().drawPiece(canvas);
        judgeWinner.checkGameOver();
    }

    /**
     * 清除全部棋子
     */
    public void deletePiece(){
        GbPanelView.mWhiteArray.clear();
        GbPanelView.mBlackArray.clear();
        isGameOver=true;
        DrawGb.getInstance().isWhiteWinner=false;
        GbPanelAty.tvVictory.setText("");
        invalidate();
    }


}
