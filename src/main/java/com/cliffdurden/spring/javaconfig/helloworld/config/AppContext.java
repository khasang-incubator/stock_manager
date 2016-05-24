package com.cliffdurden.spring.javaconfig.helloworld.config;


import com.cliffdurden.spring.javaconfig.helloworld.dao.EmployeeDao;
import com.cliffdurden.spring.javaconfig.helloworld.dao.EmployeeInfoDao;
import com.cliffdurden.spring.javaconfig.helloworld.model.DataExample;
import com.cliffdurden.spring.javaconfig.helloworld.model.Message;
import com.cliffdurden.spring.javaconfig.helloworld.util.DBBackupCommandRunner;
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
        Message msg = new Message();
        msg.setMessageInfo("Follow to the white rabbit...");
        return msg;
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
    public DBBackupCommandRunner dbBackupCommandRunner(){
        return new DBBackupCommandRunner();
    }
}
