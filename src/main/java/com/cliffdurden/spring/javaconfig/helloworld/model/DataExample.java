package com.cliffdurden.spring.javaconfig.helloworld.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class DataExample {

    private JdbcTemplate jdbcTemplate;
    private String result;

    public DataExample(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createDataTable() {
        try {
            jdbcTemplate.execute("CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY NOT NULL)");
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
