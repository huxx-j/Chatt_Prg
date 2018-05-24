package com.huxx.client;

import com.huxx.vo.MessageVo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Socket socket = new Socket("192.168.1.27", 5050);
            System.out.println("연결이 되었습니다.");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            System.out.print("id를 입력하세요 > ");
            String id = scanner.next();

            System.out.println("채팅을 시작합니다.");

            Thread thread = new Thread(new ClientTread(objectInputStream));
            thread.start();

            while (true){
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
