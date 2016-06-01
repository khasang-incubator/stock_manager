package io.khasang.stockmanager.controller;


import io.khasang.stockmanager.config.AppContext;
import io.khasang.stockmanager.config.application.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, AppContext.class})
public class HelloControllerTest {

//    @Autowired
//    HelloController helloController;

//    @Test
//    public void testHelloPage() {
//
//    }

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }


    @Test
    public void shouldProcessRegistration() throws Exception {


        //SpitterRepository mockRepository = mock(SpitterRepository.class);
        //Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
        //Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
        //when(mockRepository.save(unsaved)).thenReturn(saved);


        //SpitterController controller = new SpitterController(mockRepository);


        //UserDao userDao = mock(UserDao.class);



        /*
        User userUnsaved = new User();
        userUnsaved.setFirstName("John");
        userUnsaved.setLastName("Smith");
        userUnsaved.setLogin("jsmith");
        userUnsaved.setPassword("qwerty");
        userUnsaved.setEmail("jsmith@google.com");
        userUnsaved.setRole("admin");


        User userSaved = new User();
        userSaved.setId(13l);
        userSaved.setFirstName("John");
        userSaved.setLastName("Smith");
        userSaved.setLogin("jsmith");
        userSaved.setPassword("qwerty");
        userSaved.setEmail("jsmith@google.com");
        userSaved.setRole("admin");

        */


        HelloController helloController = new HelloController();


        //MockMvc mockMvc = standaloneSetup(helloController).build();


        mockMvc.perform(post("/")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "24hours")
                .param("email", "jsmith@google.com")
                .param("role", "admin"))
                .andExpect(redirectedUrl("/registration_result"));


        /// verify(mockRepository, atLeastOnce()).save(unsaved);

        ;


        // ResultActions result = mockMvc.perform(request);
        // result.andExpect(MockMvcResultMatchers.redirectedUrl("/index"));

    }

}
