package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.dao.UserDAO;
import io.khasang.stockmanager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class RegistrationController {

    UserDAO userDAO;

    @Autowired
    public RegistrationController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(value = "/add_user", method = GET)
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        Map<String,String> roles = new LinkedHashMap<>();
        roles.put("ROLE_SUPERADMIN", "SUPERADMIN");
        roles.put("ROLE_USER", "USER");
        model.addAttribute("roleList", roles);
        return "add_user";
    }

    @RequestMapping(value = "/add_user", method = POST)
    public String addUser(@Valid @ModelAttribute("user") User user, Errors errors, Model model) {
        if (errors.hasErrors()) {
            Map<String,String> roles = new LinkedHashMap<>();
            roles.put("ROLE_SUPERADMIN", "SUPERADMIN");
            roles.put("ROLE_USER", "USER");
            model.addAttribute("roleList", roles);
            return "add_user";
        } else {
            String result = userDAO.insertToTable(user);
            return "redirect:/registration_result?result=" + result;
        }
    }

    @RequestMapping(value = "/registration_result", method = GET)
    public String showResult(@RequestParam("result") String result, Model model) {
        model.addAttribute("result", result);
        return "registration_result";
    }


    @RequestMapping(value = {"/hello/{name}"}, method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        ModelAndView model = new ModelAndView();
        model.setViewName("helloPage");
        model.addObject("crypt", new BCryptPasswordEncoder().encode(name));
        model.addObject("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return model;
    }

    @RequestMapping("/confidential/hello")
    public String info(Model model) {
        model.addAttribute("hello", "hello");
        return "newpage";
    }

    @RequestMapping("/point")
    public String point(Model model){
        return "point";
    }
}
