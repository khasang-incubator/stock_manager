package io.khasang.stockmanager.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.khasang.stockmanager.dao.EmployeeDao;
import io.khasang.stockmanager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/cliffdurden/list_employees")
    public String listEmployees(Model model) {
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employeeList = employeeDao.findAll();
        model.addAttribute("employeeList", employeeList);
        try {
            model.addAttribute("employeeList", mapper.writeValueAsString(employeeList));
        } catch (JsonProcessingException e) {
            model.addAttribute("error", e.getMessage());
            e.printStackTrace();
        }
        return "list_employees";

    }

    @RequestMapping("/cliffdurden/list_of_rich_employees")
    public String listOfRichEmployess(Model model) {
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employeeList = employeeDao.getEmployeesWithGodSalary();
        model.addAttribute("employeeList", employeeList);
        try {
            model.addAttribute("employeeList", mapper.writeValueAsString(employeeList));
        } catch (JsonProcessingException e) {
            model.addAttribute("error", e.getMessage());
            e.printStackTrace();
        }
        return "list_employees";
    }
}
