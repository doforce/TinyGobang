package com.example.vampire.tinygobang.view.myView;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.vampire.tinygobang.util.JudgeWinner;
import com.example.vampire.tinygobang.R;
import com.example.vampire.tinygobang.util.DrawBoard;

/**
 * Created by X on 2016/4/14 0014.
 */
public class BoardView extends View {
    public static BoardView boardView=null;
    private JudgeWinner judgeWinner;

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        boardView=this;
        judgeWinner=new JudgeWinner();
        DrawBoard.getInstance().init();
        DrawBoard.getInstance().mWhitePiece= BitmapFactory.decodeResource(getResources(), R.drawable.white);
        DrawBoard.getInstance().mBlackPiece= BitmapFactory.decodeResource(getResources(),R.drawable.black);
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
        DrawBoard.getInstance().sizeChanged(w);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (DrawBoard.getInstance().touchEvent(event)){
            invalidate();

            return true;
        }
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        DrawBoard.getInstance().drawBoard(canvas);
        DrawBoard.getInstance().drawPiece(canvas);
        judgeWinner.checkGameOver();
    }

}
