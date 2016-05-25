package io.khasang.stockmanager.config;

import io.khasang.stockmanager.model.DataExample;
import io.khasang.stockmanager.model.HelloMessage;
import io.khasang.stockmanager.model.pShtykov.CreateTables;
import io.khasang.stockmanager.model.pShtykov.FillData;
import io.khasang.stockmanager.model.pShtykov.OuterJoin;
import io.khasang.stockmanager.model.pShtykov.SelectDepartments;
import io.khasang.stockmanager.model.pShtykov.SelectEmployees;
import javax.annotation.PostConstruct;
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

    @Autowired
    private CreateTables createTables;

    @Autowired
    private FillData fillData;

    @Autowired
    private SelectEmployees selectEmployees;

    @Autowired
    private SelectDepartments selectDepartments;

    @Autowired
    private OuterJoin outerJoin;

    @PostConstruct
    public void process() {
        createTables.create();
        fillData.fill();
        selectEmployees.select();
        selectDepartments.select();
        outerJoin.select();
    }

    // pupil bean helloMessage
    @Bean
    public HelloMessage helloMessage() {
        return new HelloMessage();
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
}
