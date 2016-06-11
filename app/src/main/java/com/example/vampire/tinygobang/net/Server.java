package com.example.vampire.tinygobang.net;

import android.content.Context;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by edgar on 16-6-3.
 */
public class Server {
    private Context context;
    private DatagramSocket socket=null;

    public byte[] buffer=new byte[1024];
    private MulticastSocket multicastSocket=null;

    public Server(Context context){
        this.context=context;
        Constant.SERVER_IP=GetIP.get(context);
    }

    /**
     *
     */
    public void initMuSocket(){
        try {
            multicastSocket=new MulticastSocket(Constant.MU_PORT);
            InetAddress ia=InetAddress.getByName(Constant.MU_IP);

            byte[] serverIP=Constant.SERVER_IP.getBytes();
            DatagramPacket packet=new DatagramPacket(serverIP,serverIP.length,ia,Constant.MU_PORT);
            multicastSocket.send(packet);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                multicastSocket.close();
        }
    }

}
