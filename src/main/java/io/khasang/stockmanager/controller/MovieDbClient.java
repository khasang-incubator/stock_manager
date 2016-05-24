package io.khasang.stockmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieDbClient {

    @RequestMapping("cliffdurden/movie_client")
    public String movieClient() {
        return "movie_db_client";
    }
}
