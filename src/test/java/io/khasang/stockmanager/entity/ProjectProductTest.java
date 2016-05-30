package io.khasang.stockmanager.entity;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;


public class ProjectProductTest {

    private ProjectProduct projectProduct;
    private Date currentDate;

    @Before
    public void setUp() {
        currentDate = new Date();
        projectProduct = new ProjectProduct();
        projectProduct.setProjectId(1l);
        projectProduct.setAmount(3);
        projectProduct.setPrice(new BigDecimal(20));
        projectProduct.setSumm(new BigDecimal(60));
        projectProduct.setDate(currentDate);
    }

    @Test
    public void testProjectId() {
        assertSame("project id is wrong", 1l, projectProduct.getProjectId());
    }

    @Test
    public void testAmount() {
        assertSame("amount is wrong", 3, projectProduct.getAmount());
    }

    @Test
    public void testPrice() {
        assertEquals("price is wrong", new BigDecimal(20), projectProduct.getPrice());
    }

    @Test
    public void testSumm() {
        assertEquals("summ is wrong", new BigDecimal(60), projectProduct.getSumm());
    }

    @Test
    public void testDate() {
        assertEquals("date is wrong", currentDate, projectProduct.getDate());
    }
}
