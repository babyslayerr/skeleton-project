package com.example.hanghaeprestudy.common;

import lombok.Data;

@Data
public class Message {
    private String message;
    private Integer code;
    private Object data;

    public void setSuccess(){
        this.message = "OK";
        this.code = 200;
    }
}
