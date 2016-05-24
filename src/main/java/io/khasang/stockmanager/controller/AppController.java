package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.model.DataExample;
import io.khasang.stockmanager.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    Message message;
    @Autowired
    private DataExample dataExample;

    @RequestMapping("/")
    public String shrink(Model model) {
        model.addAttribute("hello", message.getMessageInfo());
        return "hello";
    }

    @RequestMapping("/confidential")
    public String securePage(Model model) {
        model.addAttribute("cat", "Barsik");
        return "cat";
    }

    @RequestMapping("/confidential/tablecreate")
    public String tableCreate(Model model) {
        model.addAttribute("tablecreate", dataExample.createDataTable());
        return "tablecreate";
    }

    @RequestMapping("/confidential/selection")
    public String selection(Model model) {
        model.addAttribute("selection", dataExample.getSelection());
        return "selection";
    }
}
