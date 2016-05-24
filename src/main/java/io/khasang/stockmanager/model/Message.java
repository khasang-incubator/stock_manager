package io.khasang.stockmanager.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;

public class Message {
    @Autowired
    DataExample dataExample;

    public Message() {
    }

    public String getMessageInfo() {
        return "blabla";
    }

}
