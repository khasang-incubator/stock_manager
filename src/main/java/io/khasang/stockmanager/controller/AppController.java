package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.dao.BackupDB;
import io.khasang.stockmanager.dao.InsertToTable;
import io.khasang.stockmanager.dao.UserDAO;
import io.khasang.stockmanager.model.DataExample;
import io.khasang.stockmanager.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private DataExample dataExample;
    @Autowired
    private ProductOrder productOrder;
    @Autowired
    private InsertToTable insertToTable;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BackupDB backupDB;

    @RequestMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/403")
    public String forbidden() {
        return "403";
    }

    @RequestMapping("/admin/changerole")
    public String changeRole(Model model) {
        model.addAttribute("users", userDAO.getAll());
        return "changerole";
    }

    @RequestMapping("/admin/backup")
    public String backup(Model model) {
        model.addAttribute("backup", backupDB.makeBackup());
        return "backup";
    }

}
