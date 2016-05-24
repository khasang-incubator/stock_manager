package com.cliffdurden.spring.javaconfig.helloworld.controller;

import com.cliffdurden.spring.javaconfig.helloworld.util.DBBackupCommandRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DumpController {

    @Autowired
    DBBackupCommandRunner dbBackupCommandRunner;

    @RequestMapping("/cliffdurden/dump_db")
    public String dumpDb(Model model) {
        model.addAttribute("dumpResult", dbBackupCommandRunner.backup());
        return "dump_db";
    }


}
