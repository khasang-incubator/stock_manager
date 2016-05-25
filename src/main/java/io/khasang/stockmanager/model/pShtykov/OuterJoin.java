package io.khasang.stockmanager.model.pShtykov;

import io.khasang.stockmanager.model.pShtykov.datalanguage.Dml;
import io.khasang.stockmanager.model.pShtykov.model.Department;
import io.khasang.stockmanager.model.pShtykov.model.Employee;
import io.khasang.stockmanager.model.pShtykov.model.EmployeeDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Configuration
public class OuterJoin {

    @Autowired
    private Dml dml;

    private ArrayList<EmployeeDepartment> result = new ArrayList();

    public OuterJoin() {
    }

    public void select() {
        String query = "SELECT "
                + "e.id AS eId, "
                + "e.employee AS eEmployee, "
                + "e.room AS eRoom, "
                + "d.id AS dId, "
                + "d.department AS dDepartment, "
                + "d.room AS dRoom "
                + "FROM employees e "
                + "FULL OUTER JOIN "
                + "departments d "
                + "ON e.room = d.room;";
        ResultSet rs = (ResultSet) (dml.selectOrUpdate(query));
        try {
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("eId"), rs.getString("eEmployee"), rs.getInt("eRoom"));
                Department department = new Department(rs.getInt("dId"), rs.getString("dDepartment"), rs.getInt("dRoom"));
                EmployeeDepartment employeeDepartment = new EmployeeDepartment(employee, department);
                result.add(employeeDepartment);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<EmployeeDepartment> getResult() {
        return result;
    }

    public void setResult(ArrayList<EmployeeDepartment> result) {
        this.result = result;
    }

}
