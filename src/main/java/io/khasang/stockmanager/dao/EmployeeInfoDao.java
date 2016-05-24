package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.model.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EmployeeInfoDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<EmployeeInfo> findAll() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(
                "select employees.first_name, employees.last_name, employees.position, employees.phone, employees.email, depts.name as dept_name, depts.description as dept_description " +
                        "from employees inner join depts on employees.dept_id = depts.id;");
        List<EmployeeInfo> employeeInfoRows = new LinkedList<>();
        for (Map row : rows) {
            EmployeeInfo employeeInfo = new EmployeeInfo();
            employeeInfo.setFirstName((String) row.get("first_name"));
            employeeInfo.setLastName((String) row.get("last_name"));
            employeeInfo.setPhone((String) row.get("phone"));
            employeeInfo.setEmail((String) row.get("email"));
            employeeInfo.setPosition((String) row.get("position"));
            employeeInfo.setDeptName((String) row.get("dept_name"));
            employeeInfo.setDeptDescription((String) row.get("dept_description"));
            employeeInfoRows.add(employeeInfo);

        }
        return employeeInfoRows;
    }
}
