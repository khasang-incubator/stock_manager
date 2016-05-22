package com.cliffdurden.spring.javaconfig.helloworld.controller;

import com.cliffdurden.spring.javaconfig.helloworld.model.DataExample;
import com.cliffdurden.spring.javaconfig.helloworld.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @Autowired
    Message message;

    @Autowired
    DataExample dataExample;

    @RequestMapping("cliffdurden/sayhello")
    public String hello(Model model) {
        model.addAttribute("message", message.getMessageInfo());
        return "hello";
    }

    @RequestMapping("cliffdurden/tablecreate")
    public String tableCreate(Model model){
        model.addAttribute("tablecreate", dataExample.getResult());
        return "tablecreate";
    }

}
