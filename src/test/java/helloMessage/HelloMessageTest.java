package helloMessage;

import io.khasang.stockmanager.model.HelloMessage;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
public class HelloMessageTest {

//    @Autowired
//    private HelloMessage helloMessage;
    @Test
    public void testGetMessage() {
        HelloMessage helloMessage = new HelloMessage();
        assertEquals("Message from HelloMessage class", helloMessage.message);
    }
}
