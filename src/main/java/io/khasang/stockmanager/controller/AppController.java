package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.model.DataExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    DataExample dataExample;

    @RequestMapping("/")
    public String shrink(Model model) {
        model.addAttribute("hello", "");
        return "hello";
    }

    @RequestMapping("/confidential")
    public String securePage(Model model){
        model.addAttribute("cat", "Barsik");
        return "cat";
    }

    @RequestMapping("/confidential/tablecreate")
    public String tableCreate(Model model){
        model.addAttribute("tablecreate", dataExample.getResult());
        return "tablecreate";
    }

    @RequestMapping("/developermsv")
    public String mainTableStock(Model model){
        model.addAttribute("column_category", dataExample.getCategory());
        return "stockbalance";
    }


}
