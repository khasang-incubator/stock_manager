package io.khasang.stockmanager.model;

import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

public class UserEditorTest {
    String id;
    String name;
    String surname;
    String login;
    String password;
    String email;
    String role;
    String newUser;

    UserEditor userEditor = new UserEditor();

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
//    }
}
