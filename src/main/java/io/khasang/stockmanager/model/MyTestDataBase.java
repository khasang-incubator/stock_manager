package io.khasang.stockmanager.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MyTestDataBase {
    @Autowired
    Environment environment;

    private JdbcTemplate jdbcTemplate;
//    private String result = "";

    private int id;
    private String name;
    private String size;
    private String unit;
    private int quantity;
    private float cost;

    public MyTestDataBase() {
    }

    public MyTestDataBase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List selectWholeTestTable() throws SQLException {
        return this.jdbcTemplate.query("SELECT * " +
                "FROM stockitems;", new TestItemMapper());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

}

final class TestItemMapper implements RowMapper<MyTestDataBase> {
    public MyTestDataBase mapRow(ResultSet rs, int rowNum) throws SQLException {
        MyTestDataBase testDataBase = new MyTestDataBase();
        testDataBase.setId(rs.getInt("id"));
        testDataBase.setName(rs.getString("name"));
        testDataBase.setSize(rs.getString("size"));
        testDataBase.setUnit(rs.getString("unit"));
        testDataBase.setQuantity(rs.getInt("quantity"));
        testDataBase.setCost(rs.getFloat("cost"));
        return testDataBase;
    }
}