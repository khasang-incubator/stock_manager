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

    private int id;
    private String name;
    private String size;
    private String unit;
    private int quantity;
    private float cost;
    private int owner_id;

    public MyTestDataBase() {
    }

    public MyTestDataBase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List selectWholeTestTable() throws SQLException {
        return this.jdbcTemplate.query("SELECT * " +
                "FROM stock_items ORDER BY id;", new TestItemMapper());
    }

    public String dropAndCreateTestTable() throws SQLException {
        String result;
        try {
            Boolean isTableExists = jdbcTemplate.queryForObject("select exists " +
                    "(select 1 from information_schema.tables where table_name='stock_items');", Boolean.class);
            if (isTableExists) {
                jdbcTemplate.execute("DROP TABLE stock_items;");
            }
            jdbcTemplate.execute("CREATE TABLE stock_items " +
                    "(ID INT PRIMARY KEY NOT NULL, name CHARACTER(255), size CHARACTER (255), unit CHARACTER (255)," +
                    "quantity INT, cost REAL, owner_id INT)");
            result = "Table stock_items created successful!";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
        return result;
    }

    public String fillTable() {
        String result;
        String dataForTable[] = {"01, 'Доска строганная', '20*90*6000', 'кв.м.', 100, 13000",
                "02, 'Доска строганная', '20*100*3000', 'кв.м.', 230, 15000",
                "03, 'Доска строганная', '30*100*3000', 'кв.м.', 10, 15500",
                "04, 'Доска строганная', '40*100*3000', 'кв.м.', 1340, 16000",
                "05, 'Рейка строганая', '10*20*3000', 'кв.м.', 1000, 45000",
                "06, 'Рейка строганая', '10*15*3000', 'кв.м.', 80, 35000",
                "07, 'Брус строганый', '140*140*6000', 'кв.м.', 46, 13000",
                "08, 'Брус строганый', '160*160*6000', 'кв.м.', 34, 15000",
                "09, 'Брус строганый', '180*180*6000', 'кв.м.', 108, 17000",
                "10, 'Плинтус фигурный', '12х35х3000', 'пог.м.', 300, 40",
                "11, 'Уголок наружный', '50х60х3000', 'пог.м.', 277, 55",
                "12, 'Уголок наружный', '60х60х3000', 'пог.м.', 47, 65",
                "13, 'Уголок наружный', '40х50х3000', 'пог.м.', 26, 50",
                "14, 'Уголок наружный', '50х40х3000', 'пог.м.', 800, 60"};
        try {
            for (int i = 0; i < dataForTable.length; i++) {
                jdbcTemplate.execute("insert into stock_items (id, name, size, unit, quantity, cost)" +
                        " values (" + dataForTable[i] + ");");

            }
            result = "Table stock_items filled successful!";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
        return result;
    }

    public String truncateTable() {
        String result = "";
        try {
            jdbcTemplate.execute("TRUNCATE TABLE stock_items;");
            result = "Table stock_items truncate successful!";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
        return result;
    }

    public String updateTable(int id, String name) {
        String result = "";
        String sql = "UPDATE stock_items SET name = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, new Object[]{name, id});
            result = "Table stock_items update successful!";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
        return result;
    }

    public String deleteFirstTenRows() {
        String result = "";
        String sql = "DELETE FROM stock_items " +
                "WHERE ctid IN (" +
                "SELECT ctid " +
                "FROM stock_items " +
                "ORDER BY id " +
                "LIMIT 10" +
                ");";
        try {
            jdbcTemplate.update(sql);
            result = "First 10 rows from table stock_items deleted successful!";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
        return result;
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

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
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
        testDataBase.setOwner_id(rs.getInt("owner_id"));
        return testDataBase;
    }
}