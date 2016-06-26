
package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.model.MapPoints;

public interface MapPointsService {
    public void savePoints(MapPoints mapPoints);
    public MapPoints getPointsById(Long mapPointsId);
    public void deletePointsById(Long mapPointsId);
}
