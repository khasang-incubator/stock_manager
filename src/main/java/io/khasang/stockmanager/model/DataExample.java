package io.khasang.stockmanager.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DataExample {
    @Autowired
    Environment environment;
    private JdbcTemplate jdbcTemplate;

    private String result;

    private String goods;

    private int ID;

    public DataExample() {
    }

    public DataExample(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public void createDataTable() {
        try {
            jdbcTemplate.execute("CREATE TABLE COMPANY" +
                    "(ID INT PRIMARY KEY NOT NULL," + "GOODS TEXT)");
            jdbcTemplate.execute("INSERT INTO COMPANY(ID, GOODS) VALUES(1,'ABS'),(2,'PLA'),(3,'METALL'),(4,'WOOD')," +
                    "(5,'GLASS'),(6,'FIBERGLASS'),(7,'LEATHER'),(8,'WOOL'),(9,'NYLON'),(10,'ALUMINIUM'),(11,'DIRT'),(12,'SAND'),(13,'ROOFING'),(14,'STEEL')");
            result = "Table Company created successful!";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
    }

    public void truncate() {
        try {
            jdbcTemplate.execute("TRUNCATE TABLE COMPANY");
            result = "Table Company successfully truncated";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
    }



    public void updateGoods(){
        try {
            jdbcTemplate.execute("UPDATE COMPANY SET GOODS = 'Met' WHERE GOODS='METALL'");
            result = "Table Company successfully updated";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }

    }
    public void deleteGoodsTable(){
        try {
            jdbcTemplate.execute("DROP TABLE company");
            result = "Table Company successfully deleted";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }

    }
    public void deleteTenRows(){
        try {
            jdbcTemplate.execute("DELETE FROM company where id<=10");
            result = "Table Rows successfully deleted";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }

    }
    public List selectGoodsTable() {
        return this.jdbcTemplate.query("SELECT c.id,c.goods" +
                " FROM company c;", new GoodsMapper());
    }
    public List innerJoin(){

            return this.jdbcTemplate.query("SELECT * " +
                    "FROM metals INNER JOIN company ON (company.GOODS=metals.goods);", new GoodsMapper());
    }
    public List outerJoin(){

            return this.jdbcTemplate.query("SELECT * " +
                    "FROM company FULL OUTER JOIN metals ON (company.GOODS=metals.goods);", new GoodsMapper());
    }

    public String getResultTruncate() {

        truncate();

        return result;
    }
    public String getResultUpdate() {

        updateGoods();

        return result;
    }

    public String getResultCreateTable() {

        createDataTable();

        return result;
    }
    public String getResultDeleteTable() {

        deleteGoodsTable();

        return result;
    }
    public String getResultDeleteRows() {

        deleteTenRows();

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }
}

final class GoodsMapper implements RowMapper<DataExample> {
    public DataExample mapRow(ResultSet rs, int rowNum) throws SQLException {
        DataExample dataExample = new DataExample();
        dataExample.setID(rs.getInt("id"));
        dataExample.setGoods(rs.getString("goods"));
        return dataExample;
    }
}