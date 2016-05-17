package com.cliffdurden.spring.javaconfig.helloworld.config;


import com.cliffdurden.spring.javaconfig.helloworld.model.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cliffdurden.spring.javaconfig.helloworld.controller")
public class AppContext {

    @Bean
    public Message message(){
        Message msg = new Message();
        msg.setMessageInfo("Follow to the white rabbit...");
        return msg;
    }

}
