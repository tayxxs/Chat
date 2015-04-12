package com.ori.lukai.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lukai on 4/11/2015.
 */
public class Server {
    Socket client;
    public Server(Socket c){
        this.client = c;
    }

    public void run(){
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter os = new PrintWriter(client.getOutputStream());
            BufferedReader srcin = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String fis = is.readLine();
                System.out.println("Client : " + fis);
                String fsrc = srcin.readLine();
                os.println(fsrc);
                os.flush();
                if(fsrc.equals("end")){
                    break;
                }
            }
            is.close();
            os.close();
            client.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);//listen the 8080
        while(true){
            Server s = new Server(server.accept());
            s.run();
        }
    }
}
