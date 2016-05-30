package io.khasang.stockmanager.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    //users(id, фио, login, password, e-mail, роль).
    private User user;

    @Before
    public void setUp() {
        user = new User();
        user.setFirstName("John");
        user.setLastName("Smith");
        user.setLogin("jsmith");
        user.setPassword("qwerty");
//        user.setEmail("jsmith@google.com");
//        user.setRole("admin");
    }

    @Test
    public void testFirstName() {
        assertEquals("First name is wrong", "John", user.getFirstName());
    }

    @Test
    public void testLastName() {
        assertEquals("Last name is wrong", "Smith", user.getLastName());
    }

    @Test
    public void testLogin(){
        assertEquals("login is wrong", "jsmith", user.getLogin());
    }

    @Test
    public void testPassword(){
        assertEquals("password is wrong", "qwerty", user.getPassword());
    }
}
