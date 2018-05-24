package com.huxx.server;

import com.huxx.vo.MessageVo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5050);
            System.out.println("접속대기중...");
            Socket socket = serverSocket.accept();
            System.out.println("접속되었습니다.");

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.print("아이디를 입력하세요 > ");
             String id = scanner.next();

             Thread thread = new Thread(new ServerTread(objectInputStream));
             thread.start();

             while (true) {
                 String message = scanner.next();
                 MessageVo messageVo = new MessageVo(id, message);
                 objectOutputStream.writeObject(messageVo);
                 objectOutputStream.flush();
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
