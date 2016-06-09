package io.khasang.stockmanager.config;

import io.khasang.stockmanager.dao.*;
import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.ProjectProduct;
import io.khasang.stockmanager.entity.User;
import io.khasang.stockmanager.model.UserEditor;
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
    Environment environment;

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.postgresql.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getProperty("jdbc.postgresql.username"));
        dataSource.setPassword(environment.getProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public Project project() {
        return new Project();
    }

    @Bean
    public ProjectDAO projectDAO() {
        return new ProjectDAO();
    }

    @Bean
    public ProjectProduct projectProduct() {
        return new ProjectProduct();
    }

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }

    @Bean
    public BackupDB backup() {
        return new BackupDBImpl();
    }

    @Bean
    public RestoreDB restore() {
        return new RestoreDBImpl();
    }

    @Bean
    public UserEditor userEditor() {
        return new UserEditor();
    }
}
