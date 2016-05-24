package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.model.EmployeeSalary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SalariesDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void updateSalaryByEmployeeId(final long employeeId, final long newSalary) {
        String updateStatement = "UPDATE salaries"
                + " SET salary=?"
                + " WHERE employee_id=?";
        jdbcTemplate.update(updateStatement, new Object[]{newSalary, employeeId});
    }

    public List<EmployeeSalary> findAll() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(
                "select employees.id ,employees.first_name, employees.last_name, employees.position, employees.phone, employees.email, " +
                        "salaries.currency as currency, salaries.salary as salary " +
                        "from employees inner join salaries on employees.id = salaries.employee_id;");
        List<EmployeeSalary> employeeSalariesRows = new LinkedList<>();
        for (Map row : rows) {
            EmployeeSalary employeeSalary = new EmployeeSalary();
            employeeSalary.setId((int) row.get("id"));
            employeeSalary.setFirstName((String) row.get("first_name"));
            employeeSalary.setLastName((String) row.get("last_name"));
            employeeSalary.setPhone((String) row.get("phone"));
            employeeSalary.setEmail((String) row.get("email"));
            employeeSalary.setPosition((String) row.get("position"));
            employeeSalary.setSalary((int) row.get("salary"));
            employeeSalary.setCurrency((String) row.get("currency"));
            employeeSalariesRows.add(employeeSalary);
        }
        return employeeSalariesRows;
    }
}
