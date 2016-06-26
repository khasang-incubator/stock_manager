package io.khasang.stockmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MapController {

    @RequestMapping("/confidential.desk/viewMap")
    public String getMap(Model model) {
        return "point";
    }
}
