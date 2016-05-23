package io.khasang.stockmanager.model.pShtykov;

import io.khasang.stockmanager.model.pShtykov.datalanguage.Dml;
import io.khasang.stockmanager.model.pShtykov.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Configuration
public class SelectDepartments {

    @Autowired
    private Dml dml;

    private ArrayList<Department> result = new ArrayList();

    public SelectDepartments() {
    }
    
    public void select() {
        String query = "SELECT * "
                + "FROM departments;";
        ResultSet rs = (ResultSet) (dml.selectOrUpdate(query));
        try {
            while (rs.next()) {
                Department department = new Department(rs.getInt("id"), rs.getString("department"), rs.getInt("room"));
                result.add(department);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Department> getResult() {
        return result;
    }

    public void setResult(ArrayList<Department> result) {
        this.result = result;
    }

}
