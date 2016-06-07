package io.khasang.stockmanager.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductOrder {

    @Autowired
    Environment environment;

    public ProductOrder() {
    }

    public ProductOrder(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;
    private int id;
//    private String user;
//    private String url;
//    private int timespent;

    public List selectWholeTable() throws SQLException {
        return this.jdbcTemplate.query("select id "
                + "from template;", new ItemMapper());
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getUser() {
//        return user;
//    }
//
//    public void setUser(String user) {
//        this.user = user;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public void setTimespent(int timespent) {
//        this.timespent = timespent;
//    }
    public int getId() {
        return id;
    }

//    public int getTimespent() {
//        return timespent;
//    }
}

final class ItemMapper implements RowMapper<ProductOrder> {

    public ProductOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductOrder productorder = new ProductOrder();
        productorder.setId(rs.getInt("id"));
//        productorder.setUser(rs.getString("user"));
//        productorder.setUrl(rs.getString("url"));
//        productorder.setTimespent(rs.getInt("timespent"));
        return productorder;
    }
}
