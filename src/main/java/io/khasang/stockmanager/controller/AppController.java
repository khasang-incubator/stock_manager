package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.model.HelloMessage;
import io.khasang.stockmanager.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @Autowired
    private Message message;

    private HelloMessage helloMessage;

    public AppController() {
    }

    // wired pupil bean through constructor injecting
    @Autowired
    public AppController(HelloMessage helloMessage) {
        this.helloMessage = helloMessage;
    }

    @RequestMapping("/")
    public String shrink(Model model) {
        model.addAttribute("hello", message.getMessageInfo());
        model.addAttribute("helloMessage", helloMessage.message);
        return "hello";
    }
}
