package io.khasang.stockmanager.model;

import io.khasang.stockmanager.config.AppContext;
import io.khasang.stockmanager.config.AppSecurityConfig;
import io.khasang.stockmanager.config.HibernateConfig;
import io.khasang.stockmanager.config.application.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.security.InvalidParameterException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppContext.class,
        HibernateConfig.class, WebConfig.class, AppSecurityConfig.class})
public class UserEditorTest {
    private String id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;
    private String role;
    private String newUser;

    private UserEditor userEditor = new UserEditor();

    @Before
    public void setup() {
        id = "";
        name = "";
        surname = "";
        login = "";
        password = "";
        email = "";
        role = "";
        newUser = "";
    }

    @Test(expected = InvalidParameterException.class)
    public void allNullsTest() {
        id = null;
        name = null;
        surname = null;
        login = null;
        password = null;
        email = null;
        role = null;
        newUser = null;
        userEditor.defineUserOperationsByParams(id, name, surname, login, password, email, role, newUser);
    }

    @Test(expected = InvalidParameterException.class)
    public void importantParamsTest() {
        login = null;
        role = null;
        userEditor.defineUserOperationsByParams(id, name, surname, login, password, email, role, newUser);
    }

    @Test(expected = InvalidParameterException.class)
    public void passwordForNewUserTest() {
        newUser = "on";
        password = null;
        userEditor.defineUserOperationsByParams(id, name, surname, login, password, email, role, newUser);
    }

//    @Test
//    public void defineUserOperationsByParamsTest() {
//        newUser = "off";
//        password = ;
//        Assert.assertEquals("Something wrong", userEditor.defineUserOperationsByParams(id, name, surname,
//                login, password, email, role, newUser));
//    }*/
}
