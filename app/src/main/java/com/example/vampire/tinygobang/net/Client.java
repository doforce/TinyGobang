package com.example.vampire.tinygobang.net;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * Created by edgar on 16-6-3.
 */
public class Client {
    private MulticastSocket multicastSocket=null;
    private static final String TAG = "Client";

    public void listenMu(){
        try {
            InetAddress ia=InetAddress.getByName(Constant.MU_IP);
            multicastSocket=new MulticastSocket(Constant.MU_PORT);
            multicastSocket.joinGroup(ia);

            byte[] bytes=new byte[512];
            DatagramPacket packet=new DatagramPacket(bytes,bytes.length);
            multicastSocket.receive(packet);
            getServerIp(packet);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            multicastSocket.close();
        }
    }

    public String getServerIp(DatagramPacket packet){
        String ip=new String(packet.getData(),0,packet.getLength());
        Log.e(TAG, "getServerIp: "+ip);
        return ip;
    }
}
