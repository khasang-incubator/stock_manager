package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.Location;

import java.util.List;

public interface LocationDAO {
    List<Location> getAll();

    List<Location> getLocationsByUserId(Long id);

    void delete(Location location);

    void add(Location location);

    void saveOrUpdate(Location locations);
}
