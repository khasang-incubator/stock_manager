package io.khasang.stockmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HelloController {



    @RequestMapping(value="/add_user", method=POST)
    public String addUser() {
        return "redirect:/registration_result";
    }

    @RequestMapping(value="/registration_result", method=GET)
    public String showResult(){
        return "registration_result";
    }
}
