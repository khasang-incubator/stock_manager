package io.khasang.stockmanager.model.pShtykov;

import io.khasang.stockmanager.model.pShtykov.datalanguage.Dml;
import io.khasang.stockmanager.model.pShtykov.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Configuration
public class SelectEmployees {

    @Autowired
    private Dml dml;

    private ArrayList<Employee> result = new ArrayList();

    public SelectEmployees() {
    }

    public void select() {
        String query = "SELECT * "
                + "FROM employees;";
        ResultSet rs = (ResultSet) (dml.selectOrUpdate(query));
        try {
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"), rs.getString("employee"), rs.getInt("room"));
                result.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Employee> getResult() {
        return result;
    }

    public void setResult(ArrayList<Employee> result) {
        this.result = result;
    }

}
