package io.khasang.stockmanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CrudDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String createTable() {
        String result = "";
        try {
            Boolean isTableExists = jdbcTemplate.queryForObject("select exists (select 1 from information_schema.tables where table_name='cd_company');", Boolean.class);
            if (isTableExists) {
                jdbcTemplate.execute("DROP TABLE cd_company;");
            }
            jdbcTemplate.execute("CREATE TABLE cd_company " +
                    "(ID INT PRIMARY KEY NOT NULL, name CHARACTER(255), city CHARACTER (255))");
            result = "Table Company created successful!";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
        return result;
    }

    public String truncateTable() {
        String result = "";
        try {
            jdbcTemplate.execute("TRUNCATE TABLE cd_company;");
            result = "Table Company created successful!";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
        return result;
    }

    public String fillTable() {
        String result = "";
        try {
            jdbcTemplate.execute("insert into cd_company (id, name, city) values (1, 'VimBilDum', 'Houston');");
            jdbcTemplate.execute("insert into cd_company (id, name, city) values (2, 'CocaCola', 'New York');");
            jdbcTemplate.execute("insert into cd_company (id, name, city) values (3, 'Apple', 'Toronto');");
            jdbcTemplate.execute("insert into cd_company (id, name, city) values (4, 'Tesla', 'Colorado');");
            jdbcTemplate.execute("insert into cd_company (id, name, city) values (5, 'HP', 'Moscow');");
            jdbcTemplate.execute("insert into cd_company (id, name, city) values (6, 'Canon', 'Pekin');");
            jdbcTemplate.execute("insert into cd_company (id, name, city) values (7, 'Panasonic', 'Kazan');");
            jdbcTemplate.execute("insert into cd_company (id, name, city) values (8, 'IBM', 'Paris');");
            jdbcTemplate.execute("insert into cd_company (id, name, city) values (9, 'Benq', 'Kolobok');");
            jdbcTemplate.execute("insert into cd_company (id, name, city) values (10, 'Samsung', 'Minsk');");
            jdbcTemplate.execute("insert into cd_company (id, name, city) values (11, 'Mcdonalds', 'London');");
            jdbcTemplate.execute("insert into cd_company (id, name, city) values (12, 'KFC', 'Berlin');");
            jdbcTemplate.execute("insert into cd_company (id, name, city) values (13, 'Burn', 'Venna');");
            jdbcTemplate.execute("insert into cd_company (id, name, city) values (14, 'Visa', 'Tokio');");
            result = "Table Company filled successful!";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
        return result;
    }

    public String deleteRows(final int count) {
        String result = "";
        try {
            jdbcTemplate.execute("delete from cd_company where id in (select id from cd_company limit " + count + ");");
            result = "Table Company filled successful!";
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
        return result;
    }


}
