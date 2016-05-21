package io.khasang.stockmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping("/")
    public String shrink(Model model) {
        return "hello";
    }

    @RequestMapping("/azhmylev/translator")
    public String translate(Model model) {
        return "translator";
    }
}
