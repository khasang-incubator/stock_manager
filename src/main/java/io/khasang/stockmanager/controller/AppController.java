package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.dao.InsertToTable;
import io.khasang.stockmanager.model.DataExample;
import io.khasang.stockmanager.model.ProductOrder;
import io.khasang.stockmanager.model.StockBalanceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class AppController {
    @Autowired
    DataExample dataExample;
    @Autowired
    ProductOrder productOrder;
    @Autowired
    InsertToTable insertToTable;

    @Autowired
    StockBalanceData stockBalanceData;

    @RequestMapping("/")
    public String shrink(Model model) {
        model.addAttribute("hello", "");
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


    @RequestMapping("/developermsv")
    public String mainTableStock(Model model) {
        model.addAttribute("column_category", stockBalanceData.getCategory());
        return "stockbalance";
    }

    @RequestMapping("/developermsv/update")
    public String mainTableStockUpdate(Model model) {
        model.addAttribute("column_category", stockBalanceData.getResultUpdate());
        return "stockbalance";
    }

    @RequestMapping("/developermsv/backup")
    public String makeBackup(Model model) {
        model.addAttribute("column_category", stockBalanceData.makeBackup());
        return "stockbalance";
    }

    @RequestMapping("/select")
    public String items(Model model) throws SQLException {
        model.addAttribute("items", productOrder.selectWholeTable());
        return "select";
    }

    @RequestMapping(value = {"/krokodil"})
    public String home(Model model) {
        model.addAttribute("krokodil", insertToTable.getResult(200, "ref"));
        return "home";
    }

    @RequestMapping("/init_category")
    public String initTableCategory(Model model) {
        model.addAttribute("category", insertToTable.initTableCategory());
        return "category";
    }
    }

