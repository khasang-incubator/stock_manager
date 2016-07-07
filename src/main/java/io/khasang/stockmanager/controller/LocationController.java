package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.dao.LocationDAO;
import io.khasang.stockmanager.dao.UserDAO;
import io.khasang.stockmanager.entity.Location;
import io.khasang.stockmanager.model.LocationEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/service/location")
public class LocationController {
    @Autowired
    private LocationDAO locationDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private LocationEditor locationEditor;

    public LocationController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Location> getCoordinates(Principal principal) {
        List<Location> locations = locationDAO.getLocationsByUserId(userDAO.getUserIdByLogin(principal.getName()));
//        Location location = new Location(55.74954f, 37.621587f);
        return locations;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String setCoordinates(Principal principal, @RequestBody List<Location> locations) {
        try {
            System.out.println(principal.getName());
            locations.forEach(System.out::println);
            locationEditor.saveLocations(principal.getName(), locations);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
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
