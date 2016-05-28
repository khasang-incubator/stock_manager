package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.dao.SelectDao;
import io.khasang.stockmanager.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private SelectDao selectDao;


    @RequestMapping("/")
    public String shrink(Model model) {
        return "hello";
    }

    @RequestMapping("/azhmylev/translator")
    public String translate(Model model) {
        return "translator";
    }

    @RequestMapping("/azhmylev/innerSelect")
    public String innerSelect(Model model) {
        List<Product> products = selectDao.getInnerSelect();
        model.addAttribute("products", products);
        return "inner_select";
    }


}
