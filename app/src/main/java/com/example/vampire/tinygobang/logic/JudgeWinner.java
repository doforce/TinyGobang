package com.example.vampire.tinygobang.logic;

import android.graphics.Point;

import com.example.vampire.tinygobang.util.DrawGb;
import com.example.vampire.tinygobang.view.GbPanelAty;
import com.example.vampire.tinygobang.view.GbPanelView;

import java.util.List;

/**
 * Created by X on 2016/4/14 0014.
 * 判断输赢的类
 */
public class JudgeWinner {
    /**
     * 检查游戏是否结束
     */
    public void checkGameOver() {
        boolean whiteWin=checkFiveInLine(GbPanelView.mWhiteArray);
        boolean blackWin=checkFiveInLine(GbPanelView.mBlackArray);
        if (whiteWin || blackWin){
            GbPanelView.isGameOver=true;
            DrawGb.getInstance().isWhiteWinner=whiteWin;
            String text=whiteWin?"白棋胜利":"黑棋胜利";
            GbPanelAty.tvVictory.setText(text);
            GbPanelAty.btnStart.setEnabled(true);
        }
    }

    /**
     * 判断一方是否胜利
     * @param points
     * @return
     */
    private static boolean checkFiveInLine(List<Point> points){
        for (Point p:points){
            int x=p.x;
            int y=p.y;

            if (judgeOrientation(1,0,x,y,points)>=5){//判断棋子是否横向五连
                return true;
            }else if (judgeOrientation(0,1,x,y,points)>=5){//判断棋子是否纵向五连
                return true;
            }else if (judgeOrientation(1,-1,x,y,points)>=5){//判断棋子是否右上角到左下角五连
                return true;
            }else if (judgeOrientation(1,1,x,y,points)>=5){//判断棋子是否左上角到右下角五连
                return true;
            }
        }

        return false;
    }

    /**
     * 判断下棋五连的方向
     * @return
     */
    private static int judgeOrientation(int xChange,int yChange,int x,int y,List<Point> points){
        int count=1;
        int i=1;
        int xBuffer=xChange;
        int yBuffer=yChange;
        while (i<5) {
            if (points.contains(new Point(x+xChange, y+yChange))) {
                count++;
                if (xChange != 0)
                    xChange++;
                if (yChange != 0) {
                    if (yChange > 0)
                        yChange++;
                    else
                        yChange--;
                }
            }
            i++;
        }
        if (count<5){
            xChange=xBuffer;
            yChange=yBuffer;
            i=1;
            while (i<5){
                if (points.contains(new Point(x-xChange,y-yChange))){
                    count++;
                    if (xChange!=0)
                        xChange++;
                    if (yChange!=0){
                        if (yChange>0)
                            yChange++;
                        else
                            yChange--;
                    }
                }
                i++;
            }
        }
        return count;
    }
}
