package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.model.Location;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class JerseyController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Location getCoordinates() {
        Location location = new Location(1, 1);
        return location;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String setCoordinates(Location location) {
        return "success";
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCoordinates() {
        return "success";
    }
}
