package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.model.DataExample;
import io.khasang.stockmanager.model.MyTestDataBase;
import io.khasang.stockmanager.model.ProductOrder;
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
    MyTestDataBase testDataBase;

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

    @RequestMapping("/yukon85/select")
    public String showSelectExample(Model model) throws SQLException {
        model.addAttribute("result", "Select all table:");
        model.addAttribute("items", testDataBase.selectWholeTestTable());
        return "resultoperationpage";
    }

    @RequestMapping("/yukon85/dropandcreate")
    public String dropAndCreateExample(Model model) throws SQLException {
        model.addAttribute("result", testDataBase.dropAndCreateTestTable());
        model.addAttribute("items", testDataBase.selectWholeTestTable());
        return "resultoperationpage";
    }

    @RequestMapping("/yukon85/fill")
    public String fillExample(Model model) throws SQLException {
        model.addAttribute("result", testDataBase.fillTable());
        model.addAttribute("items", testDataBase.selectWholeTestTable());
        return "resultoperationpage";
    }

    @RequestMapping("/yukon85/truncate")
    public String truncateExample(Model model) throws SQLException {
        model.addAttribute("result", testDataBase.truncateTable());
        model.addAttribute("items", testDataBase.selectWholeTestTable());
        return "resultoperationpage";
    }

    @RequestMapping("/yukon85/update")
    public String updateExample(Model model) throws SQLException {
        model.addAttribute("result", testDataBase.updateTable(2, "Доска нестроганная"));
        model.addAttribute("items", testDataBase.selectWholeTestTable());
        return "resultoperationpage";
    }

    @RequestMapping("/yukon85/delete")
    public String deleteTenRows(Model model) throws SQLException {
        model.addAttribute("result", testDataBase.deleteFirstTenRows());
        model.addAttribute("items", testDataBase.selectWholeTestTable());
        return "resultoperationpage";
    }

    @RequestMapping("/yukon85/leftjoin")
    public String leftJoin(Model model) throws SQLException {
        model.addAttribute("items", testDataBase.useOuterJoin());
        return "joinpage";
    }

    @RequestMapping("/yukon85/innerjoin")
    public String innerJoin(Model model) throws SQLException {
        model.addAttribute("items", testDataBase.useInnerJoin());
        return "joinpage";
    }

    @RequestMapping("/select")
    public String items(Model model) throws SQLException {
        model.addAttribute("items", productOrder.selectWholeTable());
        return "select";
    }


}
