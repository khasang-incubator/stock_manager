package io.khasang.stockmanager.entity;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {

    private Product product;

    @Before
    public void setUp() {
        product = new Product();
        product.setUserId(2l);
        product.setProductName("wood");
        product.setDescription("norwegian wood");
    }

    @Test
    public void testUserId() {
        assertSame("user id is wrong", 2l, product.getUserId());
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
