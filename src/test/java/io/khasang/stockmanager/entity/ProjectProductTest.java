package io.khasang.stockmanager.entity;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

public class ProjectProductTest {

    private ProjectProduct projectProduct;
    private Date currentDate;

    @Before
    public void setUp() {
        currentDate = new Date();
        projectProduct = new ProjectProduct();
        projectProduct.setProjectId(1);
        projectProduct.setAmount(3);
        projectProduct.setPrice(20);
        projectProduct.setSumm(60);
        projectProduct.setDate(currentDate);
    }

    @Test
    public void testProjectId() {
        assertEquals("project id is wrong", 1, projectProduct.getProjectId());
    }

    @Test
    public void testAmount() {
        assertEquals("amount is wrong", 3, projectProduct.getAmount());
    }

    @Test
    public void testPrice() {
        assertEquals("price is wrong", 20, projectProduct.getPrice());
    }

    @Test
    public void testSumm() {
        assertEquals("summ is wrong", 60, projectProduct.getSumm());
    }

    @Test
    public void testDate() {
        assertEquals("date is wrong", currentDate, projectProduct.getDate());
    }
}
