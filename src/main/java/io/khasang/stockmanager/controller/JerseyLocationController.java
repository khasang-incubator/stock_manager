package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.entity.Location;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/location")
public class JerseyLocationController {
    @Context
    private SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Location getCoordinates() {
        Location location = new Location(55.74954f, 37.621587f);
        return location;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Location setCoordinates(List<Location> locations) {
        locations.forEach(System.out::println);
        return new Location();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCoordinates() {
        return "success";
    }

    @GET
    @Path("/string")
    @Produces(MediaType.APPLICATION_JSON)
    public String getString() {
        return "{ya:string}";
    }
}
