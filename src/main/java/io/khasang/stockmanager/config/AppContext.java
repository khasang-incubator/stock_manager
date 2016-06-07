package io.khasang.stockmanager.config;

import io.khasang.stockmanager.dao.InsertToTable;
import io.khasang.stockmanager.dao.impl.ProjectDao;
import io.khasang.stockmanager.dao.impl.ProjectService;
import io.khasang.stockmanager.model.DataExample;
import io.khasang.stockmanager.model.Message;
import io.khasang.stockmanager.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@PropertySource("classpath:util.properties")
public class AppContext {

    @Autowired
    Environment environment;

    @Bean
    public Message message() {
        return new Message();
    }

    @Bean
    ProductOrder productOrder() {
        return new ProductOrder(jdbcTemplate());
    }

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
    public DataExample dataExample() {
        return new DataExample(jdbcTemplate());
    }

    @Bean
    public InsertToTable insertToTable() {
        return new InsertToTable();
    }

    @Bean
    public ProjectDao projectDao() {
        return new ProjectDao();
    }

    @Bean
    public ProjectService projectService() {
        return new ProjectService();
    }
}
