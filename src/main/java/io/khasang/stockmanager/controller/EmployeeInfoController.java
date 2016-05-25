package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.dao.EmployeeInfoDao;
import io.khasang.stockmanager.model.EmployeeInfo;
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

    @RequestMapping("/cliffdurden/all_employees_info_outer_join")
    public String employeeInfoDaoOuterJoin(Model model) {
        ObjectMapper mapper = new ObjectMapper();
        List<EmployeeInfo> allEmployeeInfo = employeeInfoDao.findAllOuterJoin();
        try {
            model.addAttribute("allEmployeeInfo", mapper.writeValueAsString(allEmployeeInfo));
        } catch (JsonProcessingException e) {
            model.addAttribute("error", e.getMessage());
            e.printStackTrace();
        }
        return "employee_info";
    }
}
