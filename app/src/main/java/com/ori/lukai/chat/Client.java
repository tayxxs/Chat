package com.ori.lukai.chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by lukai on 4/11/2015.
 */
public class Client {
    public static void main(String[] args) throws Exception{
        //向本机的8080端口发出客户请求
        Socket socket = new Socket(InetAddress.getLocalHost(),8080);
        BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
        PrintWriter os = new PrintWriter(socket.getOutputStream());

        BufferedReader scrin = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = scrin.readLine();
            os.println(str);
            os.flush();

            String fs = is.readLine();
            System.out.println("Server :" + fs);
            if(str.equals("end")){//输入end结束从server接收信息
                break;
            }
        }
        is.close();
        os.close();
        socket.close();
    }
}
