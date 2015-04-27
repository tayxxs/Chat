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
    public String sendLoginInfo(Object obj) {

        InetAddress add;
        String test = null;
        try {
            add = InetAddress.getByName("10.202.119.40");
            socket = new Socket(add,5469);
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
            test = (String) ois.readObject();
            ois.close();
            oos.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return test;
    }
}
