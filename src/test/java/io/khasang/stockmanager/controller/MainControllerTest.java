/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.config.AppContext;
import io.khasang.stockmanager.config.AppSecurityConfig;
import io.khasang.stockmanager.config.HibernateConfig;
import io.khasang.stockmanager.config.application.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 *
 * @author Admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppContext.class,
        HibernateConfig.class, WebConfig.class, AppSecurityConfig.class})
/*@TestExecutionListeners(listeners={ServletTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        WithSecurityContextTestExecutionListener.class})*/
public class MainControllerTest {
    
    @Autowired
    private WebApplicationContext context;
    
    private MockMvc mvc;
    
    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void adminWithUserRoleTest() throws Exception {
        mvc
                .perform(get("/admin").with(user("user").roles("USER")))
                .andExpect(status().isForbidden());
    }

    @Test
    public void adminWithAdminRoleTest() throws Exception {
        mvc
                .perform(get("/admin").with(user("user").roles("ADMIN")))
                .andExpect(status().isOk());
    }
    
    /*@Test
    public void userRegistration() throws Exception {
        MultiValueMap<String,String> params = new LinkedMultiValueMap<String, String>();
        params.add("name","vasya");
        params.add("password", "123");        
        mvc
                .perform(post("/registration").params(params))
                .andExpect(model().attributeExists("error"));
        params.add("email", "email");
        mvc
                .perform(post("/registration").params(params))
                .andExpect(status().isOk());                     
    }
       
    /*@Test
    public void checkMainForbidden() throws Exception {
        mvc
                .perform(get("/index").with(user("admin").roles("ADMIN")))
                .andExpect(status().isForbidden());                                  
    }*/
    
    /*@Test
    public void checkMainUnAuthenticated() throws Exception {
        mvc
                .perform(get("/index"))
                .andExpect(redirectedUrl("http://localhost/login"))
                .andExpect(unauthenticated());                               
    }

    @Test
    public void checkLogin() throws Exception {
        mvc
                .perform(get("/login"))
                .andExpect(status().isOk());            
    }*/
    
}
