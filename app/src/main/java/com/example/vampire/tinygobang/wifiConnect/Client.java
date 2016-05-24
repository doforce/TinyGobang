package com.example.vampire.tinygobang.wifiConnect;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by X on 2016/5/2 0002.
 */
public class Client {
    public static final int CLIENT_PORE = 9090;
    public static  String CLIENT_IP;

    private DatagramSocket sendSocket;
    private DatagramSocket receiveSocket;

    public void handler() {
         sendSocket = null;
         receiveSocket = null;
        try {
            CLIENT_IP= InetAddress.getLocalHost().getHostAddress();

            sendSocket = new DatagramSocket();
            receiveSocket = new DatagramSocket(CLIENT_PORE);

            if (Host.isFistConnection){
                new ReceiveThread(receiveSocket).receiveHostName();
                Host.isFistConnection=false;
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
