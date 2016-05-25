package io.khasang.stockmanager.config;

import io.khasang.stockmanager.dao.CrudDao;
import io.khasang.stockmanager.dao.EmployeeDao;
import io.khasang.stockmanager.dao.EmployeeInfoDao;
import io.khasang.stockmanager.dao.SalariesDao;
import io.khasang.stockmanager.model.DataExample;
import io.khasang.stockmanager.model.Message;
import io.khasang.stockmanager.model.ProductOrder;
import io.khasang.stockmanager.util.DBBackupCommandRunner;
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
    public EmployeeInfoDao employeeInfoDao() {
        return new EmployeeInfoDao();
    }

    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDao();
    }

    @Bean
    public DBBackupCommandRunner dbBackupCommandRunner() {
        return new DBBackupCommandRunner();
    }

    @Bean
    public SalariesDao salariesDao() {
        return new SalariesDao();
    }

    @Bean
    public CrudDao crudDao() {
        return new CrudDao();
    }

}
