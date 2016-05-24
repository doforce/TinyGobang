package com.example.vampire.tinygobang.wifiConnect;

import android.graphics.Point;

import com.example.vampire.tinygobang.util.TypeTransfer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by X on 2016/5/2 0002.
 */
public class ReceiveThread implements Runnable{
    private DatagramSocket receiveSocket;
    private DatagramPacket receivePacket;
    private static DatagramPacket hostPacket;

    public ReceiveThread(DatagramSocket receiveSocket) {
        this.receiveSocket = receiveSocket;
    }

    @Override
    public void run() {
        try {
            byte[] buf = new byte[1024];
            receivePacket= new DatagramPacket(buf, buf.length);
            receiveSocket.receive(receivePacket);
        } catch (IOException e) {
            System.out.println("receive fail");
        }


    }

    /**
     * 返回棋子
     * @return
     */
    public Point getPoint(){
        Point point= (Point) TypeTransfer.byteToObject(receivePacket.getData());
        return point;
    }

    /**
     * 接收主机名
     */
    public void receiveHostName(){
        byte[] buf=new byte[1024];
         hostPacket=new DatagramPacket(buf,buf.length);
        try {
            receiveSocket.receive(hostPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回主机名
     * @return
     */
    public static String getHostName(){
        String name=new String(hostPacket.getData());
        return name;
    }
}
