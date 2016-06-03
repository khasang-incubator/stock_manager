package io.khasang.stockmanager.model;

import org.junit.Test;

import java.security.InvalidParameterException;

//@RunWith(SpringJUnit4ClassRunner.class)
public class UserEditorTest {
    String id = null;
    String name = null;
    String login = null;
    String password = null;
    String email = null;
    String role = null;
    String newUser = null;

    UserEditor userEditor = new UserEditor();

    @Test(expected = InvalidParameterException.class)
    public void allNullsTest() {
        userEditor.defineUserOperationsByParams(id, name, login, password, email, role, newUser);
    }

    @Test
    public void importantParamsTest() {
        login = "sdfgs";
        role = "sdfsd";
        userEditor.defineUserOperationsByParams(id, name, login, password, email, role, newUser);
    }

    @Test(expected = InvalidParameterException.class)
    public void defineUserOperationsByParamsTest() {
        newUser = "on";
        password = null;
        userEditor.defineUserOperationsByParams(id, name, login, password, email, role, newUser);
    }

//    @Test(expected = InvalidParameterException.class)
//    public void defineUserOperationsByParamsTest() {
//        newUser = "on";
//        password = null;
//        userEditor.defineUserOperationsByParams(id, name, login, password, email, role, newUser);
//    }
}
