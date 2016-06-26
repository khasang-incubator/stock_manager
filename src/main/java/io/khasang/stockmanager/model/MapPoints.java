package io.khasang.stockmanager.model;

import org.springframework.stereotype.Component;

@Component
public class MapPoints {

    private String coordX;
    private String coordY;

    public MapPoints() {
    }

    public String getCoordX() {
        return coordX;
    }

    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }


}
