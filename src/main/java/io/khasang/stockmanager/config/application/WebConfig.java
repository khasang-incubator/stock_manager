package io.khasang.stockmanager.config.application;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("io.khasang.stockmanager.*")

public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/views/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/views/css/");
    }

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("io.khasang.stockmanager.*").addProperties(getHibernateProperties());

        return builder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.format_sql", "true");
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hibernate.hbm2ddl.auto", "create");
        return prop;
    }

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setUsername("postgres");
        ds.setPassword("1");
        return ds;
    }

    @Bean(name = "JdbcTemplate")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(testDataSource());
    }

    @Bean(name = "testDataSource")
    public DriverManagerDataSource testDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:~/test1");
        ds.setUsername("sa");
        ds.setPassword("");
        return ds;
    }

    @Bean
    public HibernateTransactionManager txManager() {
        return new HibernateTransactionManager(sessionFactory());
    }


}
