package io.khasang.stockmanager.config;

import io.khasang.stockmanager.dao.AuthorDAO;
import io.khasang.stockmanager.dao.BookDAO;
import io.khasang.stockmanager.dao.DBBackup;
import io.khasang.stockmanager.dao.SubjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:util.properties")
public class AppContext {
    @Autowired
    private Environment environment;

    @Bean
    public AuthorDAO authorDAO() {
        return new AuthorDAO(jdbcTemplate());
    }

    @Bean
    public BookDAO bookDAO() {
        return new BookDAO(jdbcTemplate());
    }

    @Bean
    public SubjectDAO subjectDAO() {
        return new SubjectDAO(jdbcTemplate());
    }

    @Bean
    public DBBackup dbBackup() {
        return new DBBackup();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    private DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.postgresql.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getProperty("jdbc.postgresql.username"));
        dataSource.setPassword(environment.getProperty("jdbc.postgresql.password"));
        return dataSource;
    }
}
