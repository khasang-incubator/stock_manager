package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.model.Location;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/location")
public class JerseyLocationController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Location getCoordinates() {
        Location location = new Location(55.74954f, 37.621587f);
        return location;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String setCoordinates(Location location) {
        System.out.println(location);
        return "{res:success}";
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
