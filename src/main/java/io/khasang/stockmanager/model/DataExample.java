package io.khasang.stockmanager.model;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataExample {
    private JdbcTemplate jdbcTemplate;

    public DataExample(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
//        createDataTable();
//        setDataToTable();
    }

    public String createDataTable() {
        jdbcTemplate.execute("" +
                "CREATE TABLE IF NOT EXISTS Company (" +
                "Id     INT PRIMARY KEY NOT NULL, " +
                "Name   VARCHAR NOT NULL" +
                ");"
        );
        return "Table created successful!";
    }

    public void setDataToTable() {
        jdbcTemplate.update("" +
                "INSERT INTO Company VALUES ('1', 'Company 1'); " +
                "INSERT INTO Company VALUES ('2', 'Company 2'); " +
                "INSERT INTO Company VALUES ('3', 'Company 3');");
    }

    public List<String> getSelection() {
        List<String> companyNames = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("" +
                "SELECT Name " +
                "FROM Company;");
        companyNames.addAll(rows.stream()
                .map(row -> row.get("Name").toString()).collect(Collectors.toList()));
        return companyNames;
    }
}
