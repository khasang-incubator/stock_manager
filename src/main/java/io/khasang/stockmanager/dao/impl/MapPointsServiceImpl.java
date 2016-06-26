package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.MapPointsService;
import io.khasang.stockmanager.model.MapPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapPointsServiceImpl implements MapPointsService{

    @Autowired
    private MapPointsDAOImpl mapPointsDAOImpl;

    public MapPointsServiceImpl() {
    }

    @Override
    public void savePoints(MapPoints mapPoints) {
        mapPointsDAOImpl.savePoints(mapPoints);
    }

    @Override
    public MapPoints getPointsById(Long mapPointsId) {
        return mapPointsDAOImpl.getPointsById(mapPointsId);
    }

    @Override
    public void deletePointsById(Long mapPointsId) {
        mapPointsDAOImpl.deletePointsById(mapPointsId);
    }

}