package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.model.DataExample;
import io.khasang.stockmanager.model.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @Autowired
    DataExample dataExample;

    // injecting pupil bean helloMessage
    @Autowired
    HelloMessage helloMessage;
    
    @RequestMapping("/")
    public String shrink(Model model) {
        model.addAttribute("hello", "");
        model.addAttribute("helloMessage", helloMessage.message);
        return "hello";
    }

    @RequestMapping("/confidential")
    public String securePage(Model model) {
        model.addAttribute("cat", "Barsik");
        return "cat";
    }

    @RequestMapping("/confidential/tablecreate")
    public String tableCreate(Model model) {
        model.addAttribute("tablecreate", dataExample.getResult());
        return "tablecreate";
    }
    
    //mapping to my HTML/JS application
    @RequestMapping("/pShtykov/htmlPage")
    public String htmlPage(Model model) {
//        model.addAttribute("htmlJs", "");
        return "/pShtykov/htmlPage/htmlPage";
    }
}
