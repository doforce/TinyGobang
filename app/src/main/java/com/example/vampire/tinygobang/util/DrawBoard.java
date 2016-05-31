package com.example.vampire.tinygobang.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;

import com.example.vampire.tinygobang.view.BoardView;
import com.example.vampire.tinygobang.view.frag.GameFrag;

import java.util.LinkedList;


/**
 * Created by X on 2016/4/19 0019.
 * 画棋盘的类
 */
public class DrawBoard {
    public Paint mPaint;

    public int mPanelWidth;//棋盘宽度
    public int MAX_LINE=15;//

    public float mLineHeight;
    public float mRatioPieceLineHeight=0.75f;//棋子所占棋盘高度的比例

    public  boolean isWhiteWinner;
    public  boolean isWhite=true;//白棋先手，或者当前为白棋
    public  boolean isGameOver=true;

    public Point currentPoint;//当前的点

    public  Bitmap mWhitePiece;//白棋子资源
    public  Bitmap mBlackPiece;//黑棋子资源

    public  LinkedList<Point> mWhiteArray=new LinkedList<>();
    public  LinkedList<Point> mBlackArray=new LinkedList<>();

    /**
     * 初始化操作
     */
    public void init(){
        mPaint=new Paint();
        mPaint.setColor(Color.BLACK);
        //抗锯齿
        mPaint.setAntiAlias(true);
        //防抖动
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    public void sizeChanged(int w){
        mPanelWidth=w;
        mLineHeight=mPanelWidth*1.0f/MAX_LINE;
        //调整棋子大小
        int pieceSize= (int) (mRatioPieceLineHeight*mLineHeight);
        mWhitePiece= Bitmap.createScaledBitmap(mWhitePiece,pieceSize,pieceSize,false);
        mBlackPiece=Bitmap.createScaledBitmap(mBlackPiece,pieceSize,pieceSize,false);
    }

    public boolean touchEvent(MotionEvent event){
        if(isGameOver){
            return false;
        }

        int action=event.getAction();
        if (action==MotionEvent.ACTION_UP){
            int x= (int) event.getX();
            int y= (int) event.getY();
            currentPoint= getCurrentPoint(x,y);

            //如果该点有棋子就不绘制
            if (mWhiteArray.contains(currentPoint) || mBlackArray.contains(currentPoint)){
                return false;
            }
            if (isWhite){
                mWhiteArray.add(currentPoint);
            }else {
                mBlackArray.add(currentPoint);
            }
            //请求重绘
//            invalidate();
            isWhite=!isWhite;
            return true;
        }
        return true;
    }

    /**
     * 绘制棋子
     * @param canvas
     */
    public void drawPiece(Canvas canvas) {
        for(int i = 0; i< mWhiteArray.size(); i++){
            Point whitePoint= mWhiteArray.get(i);
            canvas.drawBitmap(mWhitePiece,
                    (whitePoint.x+(1-mRatioPieceLineHeight)/2)*mLineHeight,
                    (whitePoint.y+(1-mRatioPieceLineHeight)/2)*mLineHeight,null);
        }
        for(int i = 0; i< mBlackArray.size(); i++){
            Point blackPoint= mBlackArray.get(i);
            canvas.drawBitmap(mBlackPiece,
                    (blackPoint.x+(1-mRatioPieceLineHeight)/2)*mLineHeight,
                    (blackPoint.y+(1-mRatioPieceLineHeight)/2)*mLineHeight,null);
        }
    }

    /**
     * 绘制棋盘
     * @param canvas
     */
    public void drawBoard(Canvas canvas) {
        for (int i=0;i<MAX_LINE;i++){
            //横向棋盘线
            int startX= (int) (mLineHeight/2);
            int endX=mPanelWidth-startX;
            int y= (int) ((0.5+i)*mLineHeight);
            //横向棋盘线
            canvas.drawLine(startX,y,endX,y,mPaint);
            //纵向棋盘线
            canvas.drawLine(y,startX,y,endX,mPaint);
        }
    }

    /**
     * 精确获取下棋的坐标
     * @param x
     * @param y
     * @return
     */
    public Point getCurrentPoint(int x, int y){
        return new Point((int)(x/mLineHeight),(int)(y/mLineHeight));
    }

    /**
     * 清除全部棋子
     */
    public void deletePiece(){
        mWhiteArray.clear();
        mBlackArray.clear();
        isGameOver=true;
        DrawBoard.getInstance().isWhiteWinner=false;
        GameFrag.gameFrag.tvVictory.setText("");
        BoardView.boardView.invalidate();
    }

    /**
     * 悔棋功能
     */
    public void regret(){
        if (!isGameOver) {
            if (!mWhiteArray.isEmpty() || !mBlackArray.isEmpty()) {
                if (isWhite) {
                    mBlackArray.remove(mBlackArray.getLast());
                    BoardView.boardView.invalidate();
                    isWhite = false;
                } else {
                    mWhiteArray.remove(mWhiteArray.getLast());
                    BoardView.boardView.invalidate();
                    isWhite = true;
                }
            }
        }
    }

    /**
     * 利用单例模式创建一个DrawGb对象
     */
    private static class SingleHolder{
    private static final DrawBoard INSTANCE=new DrawBoard();
        }
    private DrawBoard(){}
    public static final DrawBoard getInstance(){

        return SingleHolder.INSTANCE;
    }
}
