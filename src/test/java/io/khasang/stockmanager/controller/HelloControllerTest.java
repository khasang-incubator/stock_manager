package io.khasang.stockmanager.controller;


import io.khasang.stockmanager.config.AppContext;
import io.khasang.stockmanager.config.application.WebConfig;
import io.khasang.stockmanager.dao.UserDao;
import io.khasang.stockmanager.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, AppContext.class})
public class HelloControllerTest {

    @Autowired
    WebApplicationContext wac;

    User userUnsaved;

    @Before
    public void setup() {
        // this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
        userUnsaved = new User();
        userUnsaved.setFirstName("Dan");
        userUnsaved.setLastName("Smith");
        userUnsaved.setLogin("jsmith");
        userUnsaved.setPassword("qwerty");
        userUnsaved.setEmail("jsmith@google.com");
        userUnsaved.setRole("admin");
    }


    @Test
    public void shouldProcessRegistration() throws Exception {
        UserDao mockUserDao = mock(UserDao.class);
        when(mockUserDao.insertToTable(userUnsaved)).thenReturn("sucessfully insert to table");
        HelloController helloController = new HelloController(mockUserDao);
        MockMvc mockMvc = standaloneSetup(helloController).build();
        mockMvc.perform(post("/add_user")
                .param("firstName", "Dan")
                .param("lastName", "Smith")
                .param("login", "jsmith")
                .param("password", "qwerty")
                .param("email", "jsmith@google.com")
                .param("role", "admin"))
                .andExpect(redirectedUrl("/registration_result"));
        verify(mockUserDao, atLeastOnce()).insertToTable(userUnsaved);
    }



}
