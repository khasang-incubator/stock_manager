package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.model.DataExample;
import io.khasang.stockmanager.model.ProductOrder;
import io.khasang.stockmanager.model.StockRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.sql.SQLException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class AppController {

    @RequestMapping("/")

    public String shrink(Model model) {
        model.addAttribute("hello", "dasd");
        return "hello";
    }

    @RequestMapping("/confidential")
    public String securePage(Model model) {
        model.addAttribute("cat", "Barsik");
        return "cat";
    }

}
