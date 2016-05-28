package jdbc;


import io.khasang.stockmanager.config.application.WebConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class})
@ImportResource("classpath:TestDataSource.xml")
public class JdbcTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Before
    public void beforeTest() {
        jdbcTemplate.execute("drop table if EXISTS products, providers");
        jdbcTemplate.execute("create table providers (id int PRIMARY KEY, name VARCHAR(50), type CHAR(1))");
        jdbcTemplate.execute("create table products (id SERIAL PRIMARY KEY, name VARCHAR(50), providerId INTEGER references Providers(id))");
        jdbcTemplate.update("INSERT INTO providers (id, name, type) VALUES (?, ?, ?)", 1, "Apple", "A");
        jdbcTemplate.update("INSERT INTO providers (id, name, type) VALUES (?, ?, ?)", 2, "Samsung", "A");
        jdbcTemplate.update("INSERT INTO providers (id, name, type) VALUES (?, ?, ?)", 3, "Nokia", "B");

        jdbcTemplate.update("INSERT INTO products (name, providerid) VALUES (?, ?)", "IPhone", 1);
        jdbcTemplate.update("INSERT INTO products (name, providerid) VALUES (?, ?)", "Galaxy", 2);
        jdbcTemplate.update("INSERT INTO products (name, providerid) VALUES (?, ?)", "Lumia", 3);
    }

    @Test
    public void innerSelectTest() {
        String[] expected = {"IPhone", "Galaxy"};
        List<String> actual = jdbcTemplate.queryForList("SELECT Name FROM Products WHERE providerid IN (SELECT ID FROM Providers WHERE type = ?)"
                , new Object[]{"A"}, String.class);
        Assert.assertArrayEquals(expected, actual.toArray());
    }


    @After
    public void afterTest() {
        jdbcTemplate.execute("drop table if EXISTS products, providers");
    }

}
