package io.khasang.stockmanager.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ExceptionDepthComparator;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

public class DataExample {
    @Autowired
    Environment environment;
    private JdbcTemplate jdbcTemplate;

    private String result;

    public DataExample(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public void createDataTable() {
        try {
            jdbcTemplate.execute("CREATE TABLE COMPANY" +
                    "(ID INT PRIMARY KEY NOT NULL,"+"GOODS TEXT)");
            jdbcTemplate.execute("INSERT INTO COMPANY(ID, GOODS) VALUES(1,'ABS'),(2,'PLA'),(3,'METALL')");
            result = "Table Company created successful!";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
    }
    public void truncate(){
        try{
            jdbcTemplate.execute("TRUNCATE TABLE COMPANY");
            result = "Table Company successfully truncated";
        }catch (Exception e){
            result = e +"";
            e.printStackTrace();
        }
    }

    public String getResultTruncate() {

            truncate();

        return result;
    } public String getResultCreateTable() {

            createDataTable();

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
