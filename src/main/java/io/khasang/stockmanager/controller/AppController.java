package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.dao.AuthorDAO;
import io.khasang.stockmanager.dao.BookDAO;
import io.khasang.stockmanager.dao.DBBackup;
import io.khasang.stockmanager.dao.SubjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private AuthorDAO authorDAO;
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private SubjectDAO subjectDAO;
    @Autowired
    private DBBackup dbBackup;

    @RequestMapping("/")
    public String shrink(Model model) {
        model.addAttribute("hello", "Hello");
        return "hello";
    }

    @RequestMapping("/confidential")
    public String securePage(Model model) {
        model.addAttribute("cat", "Barsik");
        return "cat";
    }

    @RequestMapping("/vrystsov/select")
    public String select(Model model) {
        model.addAttribute("selection", authorDAO.getAllAuthors());
        return "select";
    }

    @RequestMapping("/vrystsov/update")
    public String update(Model model) {
        model.addAttribute("update", authorDAO.updateAuthorName());
        return "update";
    }

    @RequestMapping("/vrystsov/getbooks")
    public String getBooks(Model model) {
        model.addAttribute("getBooks", bookDAO.getAllBooks());
        return "getbooks";
    }

    @RequestMapping("/vrystsov/backup")
    public String backup(Model model) {
        model.addAttribute("backup", dbBackup.backup());
        return "backup";
    }

    @RequestMapping("/vrystsov/delete")
    public String delete(Model model) {
        model.addAttribute("authors", authorDAO.getAllAuthors());
        model.addAttribute("delete", authorDAO.deleteFirstTenRows());
        return "delete";
    }
}
