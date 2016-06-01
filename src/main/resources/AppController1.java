package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.model.DataExample;
import io.khasang.stockmanager.model.ProductOrder;
import io.khasang.stockmanager.model.StockRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



import java.sql.SQLException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class AppController1 {
    @Autowired
    DataExample dataExample;

    @Autowired
    ProductOrder productOrder;

    @Autowired
    StockRegistration stockRegistration;

    @RequestMapping("/")

    public String shrink(Model model) {
        model.addAttribute("hello", "dasd");
        return "hello";
    }

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

    @RequestMapping("/romak_createTable")
    public String tableCreate(Model model) {
        model.addAttribute("tablecreate", dataExample.getResultCreateTable());
        return "tablecreate";
    }

    @RequestMapping("/romak_truncate")
    public String tableTruncate(Model model) {
        model.addAttribute("truncate", dataExample.getResultTruncate());
        return "truncate";
    }

    @RequestMapping("/confidential")
    public String securePage(Model model) {
        model.addAttribute("cat", "Barsik");
        return "cat";
    }

    @RequestMapping("/romak_select")
    public String items(Model model) throws SQLException {
        model.addAttribute("items", productOrder.selectWholeTable());
        return "select";
    }

    @RequestMapping("/romak_goodsSelect")
    public String goods(Model model) throws SQLException {
        model.addAttribute("goodsselect", dataExample.selectGoodsTable());
        return "goodsselect";
    }

    @RequestMapping("/romak_table")
    public String table(Model model) throws SQLException {
        model.addAttribute("table", "table");
        return "table";
    }

    @RequestMapping("/romak_tableUpdate")
    public String update(Model model) throws SQLException {
        model.addAttribute("goodsUpdate", dataExample.getResultUpdate());
        return "update";
    }

    @RequestMapping("/romak_deleteTable")
    public String delete(Model model) throws SQLException {
        model.addAttribute("goodsTableDelete", dataExample.getResultDeleteTable());
        return "deleteTable";
    }

    @RequestMapping("/romak_deleteTenRows")
    public String deleteRows(Model model) throws SQLException {
        model.addAttribute("deleteRows", dataExample.getResultDeleteRows());
        return "deleteTenRows";
    }

    @RequestMapping("/romak_innerJoin")
    public String innerJoin(Model model) throws SQLException {
        model.addAttribute("innerJoin", dataExample.innerJoin());
        return "innerJoin";
    }

    @RequestMapping("/romak_outerJoin")
    public String outerJoin(Model model) throws SQLException {
        model.addAttribute("outerJoin", dataExample.outerJoin());
        return "outerJoin";
    }

    @RequestMapping(value = "/romak_register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("StockRegistration", new StockRegistration());
        return "StockRegistration";
    }

    @RequestMapping(value = "/romak_register", method = POST)
    public String processRegistration(StockRegistration user) {
        stockRegistration.save(user);
        return "redirect:/romak_" +
                user.getUserName();
    }

    @RequestMapping("/romak_RegistrationTable")
    public String tableRegistrationCreate(Model model) {
        model.addAttribute("regTable", dataExample.getResultRegistrationTable());
        return "regTable";
    }


}
