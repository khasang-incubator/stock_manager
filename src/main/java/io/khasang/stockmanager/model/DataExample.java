package io.khasang.stockmanager.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

public class DataExample {

    @Autowired
    Message message;

    @Autowired
    Environment environment;

    private JdbcTemplate jdbcTemplate;

    private String result;

    public DataExample(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DataExample() {
    }

    public void createDataTable() {
        try {
            jdbcTemplate.execute("CREATE TABLE COMPANY "
                    + "(ID INT PRIMARY KEY NOT NULL)");
            result = "Table Company created successful!";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
    }

    public String getResult() {
        createDataTable();
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
