package com.ori.lukai.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by lukai on 4/11/2015.
 */
public class Client {
    public Socket socket;
    public boolean sendLoginInfo(Object obj) {
        boolean b = false;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8080);
            //客户端输出流
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(obj);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
}
