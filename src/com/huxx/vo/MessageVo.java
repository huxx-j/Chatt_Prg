package com.huxx.vo;

import java.io.Serializable;

public class MessageVo implements Serializable {
    String content;
    String id;

    public MessageVo() {
        super();
    }

    public MessageVo(String content, String id) {
        super();
        this.content = content;
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " : " + content;
    }
}
