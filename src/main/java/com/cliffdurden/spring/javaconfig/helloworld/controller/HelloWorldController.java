package com.cliffdurden.spring.javaconfig.helloworld.controller;

import com.cliffdurden.spring.javaconfig.helloworld.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @Autowired
    Message message;

    @RequestMapping("/sayhello")
    public String hello(ModelMap model) {
        model.addAttribute("message", message.getMessageInfo());
        return "hello";
    }

}
