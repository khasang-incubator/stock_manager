package com.cliffdurden.spring.javaconfig.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieDbClient {

    @RequestMapping("movie_client")
    public String movieClient() {
        return "movie_db_client";
    }
}
