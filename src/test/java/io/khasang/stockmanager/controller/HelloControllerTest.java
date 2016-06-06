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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, AppContext.class})
public class HelloControllerTest {

    User userUnsaved;
    User wrongUser;
    @Autowired
    WebApplicationContext wac;


    @Before
    public void setup() {
        userUnsaved = new User();
        userUnsaved.setFirstName("Dan");
        userUnsaved.setLastName("Smith");
        userUnsaved.setLogin("jsmith");
        userUnsaved.setPassword("qwerty");
        userUnsaved.setEmail("jsmith@google.com");
        userUnsaved.setRole("admin");
        wrongUser = new User();
        wrongUser.setFirstName("D");
        wrongUser.setLastName("S");
        wrongUser.setLogin("jsmith");
        wrongUser.setPassword("qwerty");
        wrongUser.setEmail("jsmith");
        wrongUser.setRole("admin");
    }


    @Test
    public void shouldProcessRegistration() throws Exception {
        UserDao mockUserDao = mock(UserDao.class);
        when(mockUserDao.insertToTable(userUnsaved)).thenReturn("successfully insert to table");
        HelloController helloController = new HelloController(mockUserDao);
        MockMvc mockMvc = standaloneSetup(helloController).build();
        mockMvc.perform(post("/add_user")
                .param("firstName", "Dan")
                .param("lastName", "Smith")
                .param("login", "jsmith")
                .param("password", "qwerty")
                .param("email", "jsmith@google.com")
                .param("role", "admin"))
                .andExpect(redirectedUrl("/registration_result?result=successfully insert to table"));
        verify(mockUserDao, atLeastOnce()).insertToTable(userUnsaved);
    }

    @Test
    public void testShowResult() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
        mockMvc.perform(get("/registration_result")
                .param("result", "successfully insert to table"))
                .andExpect(status().isOk())
                .andExpect(view().name("registration_result"))
                .andExpect(forwardedUrl("/WEB-INF/views/registration_result.jsp"));
    }

    @Test
    public void testAddUserGet() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
        mockMvc.perform(get("/add_user"))
                .andExpect(status().isOk())
                .andExpect(view().name("add_user"))
                .andExpect(forwardedUrl("/WEB-INF/views/add_user.jsp"));
    }

    @Test
    public void testWrongUserRegistration() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
        mockMvc.perform(post("/add_user")
                .param("firstName", "D")
                .param("lastName", "S")
                //.param("login", "jsmith")
                .param("password", "qwerty")
                .param("email", "jsmith")
                .param("role", "admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("add_user"))
                .andExpect(forwardedUrl("/WEB-INF/views/add_user.jsp"))
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.model().errorCount(2));
    }
}
