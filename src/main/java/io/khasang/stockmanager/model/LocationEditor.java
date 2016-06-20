package io.khasang.stockmanager.model;

import io.khasang.stockmanager.dao.LocationDAO;
import io.khasang.stockmanager.dao.UserDAO;
import io.khasang.stockmanager.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LocationEditor {
    @Autowired
    private LocationDAO locationDAO;
    @Autowired
    private UserDAO userDAO;

    public void saveLocations(String userLogin, List<Location> listWithNewLocations) throws RuntimeException {
            Long userID = userDAO.getUserIdByLogin(userLogin);
            for (Location location : listWithNewLocations) {
                location.setUserId(userID);
                locationDAO.saveOrUpdate(location);
            }
    }
}
