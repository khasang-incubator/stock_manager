package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.model.DataExample;
import io.khasang.stockmanager.model.HelloMessage;
import io.khasang.stockmanager.model.pShtykov.CreateTables;
import io.khasang.stockmanager.model.pShtykov.FillData;
import io.khasang.stockmanager.model.pShtykov.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @Autowired
    DataExample dataExample;

    @Autowired
    private CreateTables createTables;

    @Autowired
    private FillData fillData;

    @Autowired
    private Select select;

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

    //mapping to my HTML/JS application
    @RequestMapping("/pShtykov/jdbc")
    public String jdbc(Model model) {

        createTables.create();
        fillData.fill();
        select.select();

        model.addAttribute("createTables", createTables.getResult());
        model.addAttribute("fillData", fillData.getResult());
        model.addAttribute("select", select.getSelectResult());
        return "/pShtykov/jdbc/jdbc";
    }
}
