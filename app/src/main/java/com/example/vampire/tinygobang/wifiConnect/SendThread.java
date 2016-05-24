package com.example.vampire.tinygobang.wifiConnect;

import android.graphics.Point;

import com.example.vampire.tinygobang.dialog.ConnectModeDialog;
import com.example.vampire.tinygobang.util.DrawGb;
import com.example.vampire.tinygobang.util.TypeTransfer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by X on 2016/5/2 0002.
 */
public class SendThread implements Runnable{
    private DatagramSocket sendSocket;
    private DatagramPacket sendPacket;
    private DatagramPacket hostPacket;
    public Point point;

    private  int PORT ;
    private  String IP;

    public SendThread(DatagramSocket sendSocket) {

        this.sendSocket = sendSocket;
    }

    @Override
    public void run() {
        try {
            point= DrawGb.getInstance().currentPoint;
            byte[] sendPoint = TypeTransfer.objectToByte(point);

            /**
             * 当按下创建游戏按钮时表示要发送棋子给客户端，
             * 当按下加入游戏时表示要发送棋子给主机
             */
            if (ConnectModeDialog.isCreateGameBtnClicked){
                PORT=Client.CLIENT_PORE;
                IP=Client.CLIENT_IP;
            }else if (ConnectModeDialog.isJoinGameBtnClicked){
                PORT=Host.HOST_PORE;
                IP=Host.HOST_IP;
            }

            sendPacket = new DatagramPacket(sendPoint, sendPoint.length,
                    InetAddress.getByName(IP), PORT);
            sendSocket.send(sendPacket);
        } catch (IOException e) {
            System.out.println("send fail！");
        }
    }

    /**
     * 发送主机名
     */
    public void sendHostName(){
        byte[] host=Client.CLIENT_IP.getBytes();
        try {
            hostPacket=new DatagramPacket(host,host.length,
                    InetAddress.getByName(Client.CLIENT_IP),Client.CLIENT_PORE);
            sendSocket.send(hostPacket);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
