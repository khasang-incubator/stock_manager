package com.cliffdurden.spring.javaconfig.helloworld.controller;

import com.cliffdurden.spring.javaconfig.helloworld.dao.EmployeeInfoDao;
import com.cliffdurden.spring.javaconfig.helloworld.model.EmployeeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeInfoController {

    @Autowired
    EmployeeInfoDao employeeInfoDao;

    @RequestMapping("/cliffdurden/all_employees_info")
    public String employeeInfoDao(Model model) {
        ObjectMapper mapper = new ObjectMapper();
        List<EmployeeInfo> allEmployeeInfo = employeeInfoDao.findAll();
        try {
            model.addAttribute("allEmployeeInfo", mapper.writeValueAsString(allEmployeeInfo));
        } catch (JsonProcessingException e) {
            model.addAttribute("error", e.getMessage());
            e.printStackTrace();
        }
        return "employee_info";
    }
}
