package io.khasang.stockmanager.entity;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {

    private Product product;
    private User user;

    @Before
    public void setUp() {
        user = new User();
        user.setFirstName("John");
        user.setLastName("Smith");
        user.setLogin("jsmith");
        user.setPassword("qwerty");
        user.setEmail("jsmith@google.com");
        user.setRole("admin");
        product = new Product();
        product.setUser(user);
        product.setProductName("wood");
        product.setDescription("norwegian wood");
    }

    @Test
    public void testUserId() {
        assertSame("user id is wrong", user, product.getUser());
    }

    @Test
    public void testProductName() {
        assertEquals("product name is wrong", "wood", product.getProductName());

    }

    @Test
    public void testDescription() {
        assertEquals("description is wrong", "norwegian wood", product.getDescription());
    }
}
