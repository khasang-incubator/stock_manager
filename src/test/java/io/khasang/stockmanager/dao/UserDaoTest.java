package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.config.AppContext;
import io.khasang.stockmanager.config.application.WebConfig;
import io.khasang.stockmanager.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, AppContext.class})
public class UserDaoTest {

    @Autowired
    UserDAO userDAO;

    private User user;

    @Before
    public void setUp() {
        user = new User();
        user.setFirstName("Jack");
        user.setLastName("Smith");
        user.setLogin("jsmith");
        user.setPassword("qwerty");
        user.setEmail("jsmith@google.com");
        user.setRole("admin");
    }

    @Test
    public void testInsertToTable() {
        assertEquals("Result wrong", "successfully insert to table", userDAO.insertToTable(user));
    }

    @Test
    public void testErrorWhenInsertToTable() {
        user.setLogin(null);
        assertEquals("Result wrong", "unable to insert to table", userDAO.insertToTable(user));
    }

}
