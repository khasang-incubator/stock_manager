package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.dao.CrudDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrudController {

    @Autowired
    CrudDao crudDao;

    @RequestMapping("cliffdurden/crud/create")
    public String createTable(Model model) {
        final String result = crudDao.createTable();
        model.addAttribute("result", result);
        return "crud_result";
    }

    @RequestMapping("cliffdurden/crud/fill")
    public String fillTable(Model model) {
        final String result = crudDao.fillTable();
        model.addAttribute("result", result);
        return "crud_result";
    }

    @RequestMapping("cliffdurden/crud/delete")
    public String deleteTableRows(Model model) {
        final String result = crudDao.deleteRows(10);
        model.addAttribute("result", result);
        return "crud_result";
    }

    @RequestMapping("cliffdurden/crud/truncate")
    public String truncateTable(Model model) {
        final String result = crudDao.truncateTable();
        model.addAttribute("result", result);
        return "crud_result";
    }
}
