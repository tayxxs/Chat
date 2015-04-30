package com.ori.lukai.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by lukai on 4/11/2015.
 */
public class Client {
    public Socket socket;
    /*
    由于登陆和注册的结果都是要进入myActivity的，所以b获值true即可
     */
    public boolean sendLoginInfo(Object obj) {

        InetAddress address;
        boolean b = false;
        try {
            //连接SERVER
            address = InetAddress.getByName("192.168.1.6");
            socket = new Socket(address,5469);
            /*
            try {
                socket.connect(new InetSocketAddress("192.168.1.104",5469),2000);
            }catch (SocketTimeoutException e){
                e.printStackTrace();
            }*/
            //客户端输出流
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(obj);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            b = (boolean)ois.readObject();
            ois.close();
            oos.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return b;
    }
}
