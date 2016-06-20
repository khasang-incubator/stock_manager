package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.dao.LocationDAO;
import io.khasang.stockmanager.dao.UserDAO;
import io.khasang.stockmanager.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/service/location")
public class LocationController {
    @Autowired
    private LocationDAO locationDAO;
    @Autowired
    private UserDAO userDAO;

    public LocationController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Location> getCoordinates(Principal principal) {
        List<Location> locations = locationDAO.getLocationsByUserId(userDAO.getUserIdByLogin(principal.getName()));
//        Location location = new Location(55.74954f, 37.621587f);
        return locations;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Location setCoordinates(Principal principal, @RequestBody List<Location> locations) {

        System.out.println(principal.getName());
        locations.forEach(System.out::println);
        return new Location();
    }

//    @RequestMapping(method = RequestMethod.DELETE)
//    public String deleteCoordinates() {
//        return "success";
//    }

//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public String getString() {
//        return "{ya:string}";
//    }
}
