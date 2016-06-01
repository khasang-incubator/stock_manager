package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.dao.UserDao;
import io.khasang.stockmanager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HelloController {


    UserDao userDao;

    @Autowired
    public HelloController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value = "/add_user", method = GET)
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add_user";
    }

    @RequestMapping(value = "/add_user", method = POST)
    public String addUser(User user) {
        String result = userDao.insertToTable(user);
        return "redirect:/registration_result?result=" + result;
    }

    @RequestMapping(value = "/registration_result{result}", method = GET)
    public String showResult(@PathVariable("result") String result, Model model) {
        model.addAttribute("registration_result", result);
        return "registration_result";
    }




}
