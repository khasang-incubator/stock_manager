package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.model.DataExample;
import io.khasang.stockmanager.model.StockRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.ManyToOne;
import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class StockManagerController {
    @Autowired
    DataExample dataExample;

    @Autowired
    StockRegistration stockRegistration;

    @RequestMapping(value = "/romak_{username}", method = GET)
    public String stockMainPage(
            @PathVariable String username,
            Model model) {
        StockRegistration stockUser = stockRegistration.find(username);
        model.addAttribute(stockUser);
        return "Stock";
    }

    @RequestMapping("/romak_NewProducts")
    public String stockNewProductsPage(Model model) {
        model.addAttribute("NewProducts", "recent");
        return "NewProducts";
    }

    @RequestMapping("/romak_Entrance")
    public String stockEnterPage(Model model) {
        model.addAttribute("Entrance", "Entrance");
        return "Entrance";
    }

    @RequestMapping("/webService")
    public String returnJSONP(Model model) {
        model.addAttribute("script", "script");
        return "script";
    }

    @RequestMapping(value = "/romak_register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("StockRegistration", new StockRegistration());
        return "StockRegistration";
    }

    @RequestMapping(value = "/romak_register", method = POST)
    public String processRegistration(@Valid @ModelAttribute("StockRegistration") StockRegistration user
            , Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "StockRegistration";
        }
        stockRegistration.save(user);
        return "redirect:/romak_" +
                user.getUserName();
    }

    @RequestMapping("/romak_RegistrationTable")
    public String tableRegistrationCreate(Model model) {
        model.addAttribute("regTable", dataExample.getResultRegistrationTable());
        return "regTable";
    }

    @RequestMapping(value = "/protected**", method = RequestMethod.GET)
    public ModelAndView protectedPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Welcome to secure page!");
        model.addObject("message", "This is protected page - only for admin users!");
        model.setViewName("protected");
        return model;
    }

    @RequestMapping(value = "/point**", method = RequestMethod.GET)
    public ModelAndView point() {
        ModelAndView model = new ModelAndView();
        model.addObject("coordY", 58.76);
        model.addObject("coordX", 39.64);
        model.setViewName("point");
        return model;
    }


}
