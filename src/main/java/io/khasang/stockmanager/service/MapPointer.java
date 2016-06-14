package io.khasang.stockmanager.service;

import org.springframework.stereotype.Controller;

import javax.ws.rs.*;

@Controller
@Path("/hello/{name}")
public class MapPointer {
    @GET
    @Produces("text/plain")
    public String sayHello(@PathParam("name") String name) {
        StringBuilder stringBuilder = new StringBuilder("Hello, ");
        stringBuilder.append(name).append("!");
        return stringBuilder.toString();
    }

}