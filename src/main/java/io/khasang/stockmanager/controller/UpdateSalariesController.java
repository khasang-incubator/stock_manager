package io.khasang.stockmanager.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.khasang.stockmanager.dao.SalariesDao;
import io.khasang.stockmanager.model.EmployeeSalary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class UpdateSalariesController {

    @Autowired
    SalariesDao salariesDao;

    @RequestMapping(value = {"/cliffdurden/update_salary/", "/cliffdurden/update_salary"}, method = RequestMethod.GET)
    public String updateSalary(@RequestParam Map<String, String> allRequestParams, Model model) {
        final int employeeId = Integer.valueOf(allRequestParams.get("employee_id"));
        final int newSalary = Integer.valueOf(allRequestParams.get("new_salary"));
        salariesDao.updateSalaryByEmployeeId(employeeId, newSalary);
        updateModel(model);
        return "update_salary";
    }


    @RequestMapping("/cliffdurden/show_salaries")
    public String updateSalary(Model model) {
        updateModel(model);
        return "update_salary";
    }


    private void updateModel(Model model) {
        ObjectMapper mapper = new ObjectMapper();
        List<EmployeeSalary> employeeList = salariesDao.findAll();
        model.addAttribute("employeeSalariesList", employeeList);
        try {
            model.addAttribute("employeeSalariesList", mapper.writeValueAsString(employeeList));
        } catch (JsonProcessingException e) {
            model.addAttribute("error", e.getMessage());
            e.printStackTrace();
        }

    }
}
