package io.khasang.stockmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Import({AppContext.class})
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

//    String userAndPaswQuery = "select login, password, true from users where login = ?";
//    String autorityQuery = "select login, role from user_roles where username = ?";

    String userAndPaswQuery = "select login as principal, password as credentials, true from users where login = ?";
    //"select username, password, true from users where username = ?";
    String autorityQuery = "select login as principal, role from users where login = ?";
    //"select username, role from user_roles where username = ?";

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(userAndPaswQuery)
                .authoritiesByUsernameQuery(autorityQuery)
                .rolePrefix("ROLE_");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/confidential/**").access("hasRole('ROLE_USER')")
                .and().formLogin().loginPage("/").defaultSuccessUrl("/admin", false)
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf().disable();
    }
}
