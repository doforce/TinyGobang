package com.example.vampire.tinygobang.wifiConnect;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by X on 2016/5/2 0002.
 */
public class Host {
    //接收消息的端口
    public static final int HOST_PORE = 8080;
    public static  String HOST_IP;

    private DatagramSocket sendSocket;
    private DatagramSocket receiveSocket;

    public static boolean isFistConnection=true;

    public void handler() {
         sendSocket = null;
         receiveSocket = null;

        try {
            HOST_IP= InetAddress.getLocalHost().getHostAddress();

            sendSocket = new DatagramSocket();
            receiveSocket = new DatagramSocket(HOST_PORE);

            if (isFistConnection){
                new SendThread(sendSocket).sendHostName();
                isFistConnection=false;
            }else {
                new Thread(new SendThread(sendSocket)).start();
                new Thread(new ReceiveThread(receiveSocket)).start();
            }
        } catch (SocketException e) {
            System.out.println("handler:异常！");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
