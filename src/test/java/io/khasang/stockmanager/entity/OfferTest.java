package io.khasang.stockmanager.entity;

import io.khasang.stockmanager.config.HibernateConfig;
import io.khasang.stockmanager.config.application.WebConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.envers.query.criteria.AuditConjunction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
public class OfferTest {
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    Offer offer;

   // Session session = sessionFactory.openSession();

    @Test
    public void testOffer(){
        assertNotNull(new Offer());
    }

    @Test
    public void testOfferFormID(){
        assertNotNull(sessionFactory);
    }

    @Test
    public void testOfferInfo(){
        assertSame(123,offer.getId());
    }
}
