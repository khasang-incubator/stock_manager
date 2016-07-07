package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.dao.BackupDB;
import io.khasang.stockmanager.dao.RestoreDB;
import io.khasang.stockmanager.dao.UserDAO;
import io.khasang.stockmanager.model.UserEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import java.security.InvalidParameterException;

@Controller
public class AdminController {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BackupDB backupDB;
    @Autowired
    private RestoreDB restoreDB;
    @Autowired
    private UserEditor userEditor;

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/403")
    public String forbidden() {
        return "403";
    }

    @RequestMapping("/admin")
    public String changeRole(Model model) {
        model.addAttribute("users", userDAO.getAll());
        return "admin";
    }

    @RequestMapping(value = "/point**", method = RequestMethod.GET)
    public ModelAndView point() {
        ModelAndView model = new ModelAndView();
        model.addObject("coordY", 58.76);
        model.addObject("coordX", 39.64);
        model.setViewName("point");
        return model;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
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
        return "redirect:/admin";
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
        return "redirect:/admin";
    }

    @RequestMapping("/admin/backup")
    public String backup(Model model) {
        model.addAttribute("backup", backupDB.makeBackup());
        model.addAttribute("users", userDAO.getAll());
        return "admin";
    }

    @RequestMapping("/admin/restore")
    public String restore(Model model) {
        model.addAttribute("restore", restoreDB.makeRestore());
        model.addAttribute("users", userDAO.getAll());
        return "admin";
    }

}

