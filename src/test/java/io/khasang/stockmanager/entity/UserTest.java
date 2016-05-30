package io.khasang.stockmanager.entity;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

    //users(id, фио, login, password, e-mail, роль).
    private User user;

    @Before
    public void setUp() {
        user = new User();
        user.setFirstName("John");
//        user.setLastName("Smith");
//        user.setLogin("jsmith");
//        user.setPassword("qwerty");
//        user.setEmail("jsmith@google.com");
//        user.setRole("admin");
    }

    @Test
    public void testFirstName() {
        assertEquals("First name is wrong", "John", user.getFirstName());
    }
}
