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
    public String shrink(Model model){
        model.addAttribute("hello", "dasd");
        return "hello";
    }
    @RequestMapping("/romak_Main")
    public String stockMainPage(Model model){
        model.addAttribute("Stock","Main");
        return "Stock";
    }
    @RequestMapping("/romak_NewProducts")
    public String stockNewProductsPage(Model model){
        model.addAttribute("NewProducts","recent");
        return "NewProducts";
    }
    @RequestMapping("/romak_Entrance")
    public String stockEnterPage(Model model){
        model.addAttribute("Entrance","Entrance");
        return "Entrance";
    }
    @RequestMapping("/webService")
    public String returnJSONP(Model model){
        model.addAttribute("script","script");
        return "script";
    }
    @RequestMapping("/romak_table")
    public String tableCreate(Model model){
        model.addAttribute("tablecreate",dataExample.getResultCreateTable());
        return "tablecreate";
    }
    @RequestMapping("/romak_truncate")
    public String tableTruncate(Model model){
        model.addAttribute("truncate",dataExample.getResultTruncate());
        return "truncate";
    }

}
