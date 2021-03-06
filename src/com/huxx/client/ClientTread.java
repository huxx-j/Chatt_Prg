package com.huxx.client;

import com.huxx.vo.MessageVo;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ClientTread implements Runnable {
    ObjectInputStream objectInputStream;

    public ClientTread(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }

    @Override
    public void run() {
        while (true){
            try {
                MessageVo messageVo = (MessageVo) objectInputStream.readObject();
                System.out.println(messageVo);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
