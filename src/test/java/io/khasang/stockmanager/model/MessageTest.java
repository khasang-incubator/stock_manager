package io.khasang.stockmanager.model;

import io.khasang.stockmanager.config.application.WebConfig;
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
@ContextConfiguration(classes = {WebConfig.class})
public class MessageTest {
    @Autowired
    Message message;

    @Test
    public void testGetMessageInfo() {
        assertEquals("blabla", message.getMessageInfo());
    }

    @Test
    public void testLogicMessaging(){
        assertNotNull(new Message());
    }

}
