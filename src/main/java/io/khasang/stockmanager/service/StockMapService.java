package io.khasang.stockmanager.service;


import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Controller
@Path("romak_mapService/{name}")
public class StockMapService {
    @GET
    @Produces("text/plain")
    public String sayHello(@PathParam("name") String name){
        StringBuilder stringBuilder = new StringBuilder("Hello, ");
        stringBuilder.append(name).append("!");
        return stringBuilder.toString();
    }
}
