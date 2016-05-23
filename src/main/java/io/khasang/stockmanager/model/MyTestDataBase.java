package io.khasang.stockmanager.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class MyTestDataBase {
    @Autowired
    Environment environment;

    private JdbcTemplate jdbcTemplate;
    private String result = "";

    public MyTestDataBase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String showDataTable() {
        String sql = "SELECT * FROM stockitems";
        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
            for (Map<String, Object> row : rows) {
                result += "<tr class=\"data\">";
                for (Object obj: row.values()) {
                    result += "<th>" + obj.toString() + "</th>";
                }
                result += "</tr>";
            }
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
        return result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}