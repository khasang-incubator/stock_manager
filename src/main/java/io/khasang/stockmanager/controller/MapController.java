package io.khasang.stockmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MapController {

    @RequestMapping(value = "/point**", method = RequestMethod.GET)
    public ModelAndView point() {
        ModelAndView model = new ModelAndView();
        model.addObject("coordY", 58.76);
        model.addObject("coordX", 39.64);
        model.setViewName("point");
        return model;
    }
}
