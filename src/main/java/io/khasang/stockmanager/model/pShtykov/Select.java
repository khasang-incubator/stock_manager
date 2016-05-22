package io.khasang.stockmanager.model.pShtykov;

import io.khasang.stockmanager.model.pShtykov.datalanguage.Dml;
import io.khasang.stockmanager.model.pShtykov.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Configuration
public class Select {

    @Autowired
    private Dml dml;

    private ArrayList<Employees> result = new ArrayList();

    public Select() {
    }

    public void select() {
        String query = "SELECT * "
                + "FROM table_one;";
        ResultSet rs = (ResultSet) (dml.selectOrUpdate(query));
        try {
            while (rs.next()) {
                Employees employee = new Employees(rs.getInt("id"), rs.getString("employee"), rs.getInt("room"));
                result.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Bean
    public ArrayList<Employees> getSelectResult() {
        return result;
    }

    public void setResult(ArrayList<Employees> result) {
        this.result = result;
    }

}
