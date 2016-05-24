package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Employee> findAll() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(
                "select * from employees;");
        List<Employee> employeeRows = new LinkedList<>();
        for (Map row : rows) {
            Employee employee = new Employee();
            employee.setId((int) row.get("id"));
            employee.setFirstName((String) row.get("first_name"));
            employee.setLastName((String) row.get("last_name"));
            employee.setPhone((String) row.get("phone"));
            employee.setEmail((String) row.get("email"));
            employee.setPosition((String) row.get("position"));
            employeeRows.add(employee);
        }
        return employeeRows;
    }

}
