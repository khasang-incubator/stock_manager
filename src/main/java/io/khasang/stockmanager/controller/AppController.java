package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.dao.BackupDB;
import io.khasang.stockmanager.dao.InsertToTable;
import io.khasang.stockmanager.dao.RestoreDB;
import io.khasang.stockmanager.dao.UserDAO;
import io.khasang.stockmanager.model.DataExample;
import io.khasang.stockmanager.model.ProductOrder;
import io.khasang.stockmanager.model.UserEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.NoResultException;
import java.security.InvalidParameterException;

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
    @Autowired
    private RestoreDB restoreDB;
    @Autowired
    private UserEditor userEditor;

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

    @RequestMapping("/admin/users")
    public String changeRole(Model model) {
        model.addAttribute("users", userDAO.getAll());
        return "users";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.POST)
    public String userPost(Model model, @RequestParam(name = "id", required = false) String id,
                           @RequestParam(name = "firstName", required = false) String firstName,
                           @RequestParam(name = "lastName", required = false) String lastName,
                           @RequestParam(name = "password", required = false) String password,
                           @RequestParam(name = "login", required = false) String login,
                           @RequestParam(name = "email", required = false) String email,
                           @RequestParam(name = "role", required = false) String role,
                           @RequestParam(name = "new_user", required = false) String newUser) {
        try {
            userEditor.defineUserOperationsByParams(id, firstName, lastName, login, password, email, role, newUser);
        } catch (InvalidParameterException e) {
            model.addAttribute("error", "check your params!");
        }
        model.addAttribute("users", userDAO.getAll());
        return "redirect:/admin/users";
    }

    @RequestMapping("/admin/delete")
    public String delete(Model model,
                         @RequestParam(name = "id", required = false) String id) {
        try {
            userEditor.delete(id);
        } catch (NoResultException e) {
            model.addAttribute("error", "user not exists.");
        }
        model.addAttribute("users", userDAO.getAll());
        return "redirect:/admin/users";
    }

    @RequestMapping("/admin/backup")
    public String backup(Model model) {
        model.addAttribute("backup", backupDB.makeBackup());
        return "backup";
    }

    @RequestMapping("/admin/restore")
    public String restore(Model model) {
        model.addAttribute("restore", restoreDB.makeRestore());
        return "restore";
    }

}
