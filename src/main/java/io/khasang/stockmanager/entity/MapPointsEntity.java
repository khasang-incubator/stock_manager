package io.khasang.stockmanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "map_points")
public class MapPointsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "coord_x")
    private float coordX;

    @Column(name = "coord_y")
    private float coordY;

    public MapPointsEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getCoordX() {
        return coordX;
    }

    public void setCoordX(float coordX) {
        this.coordX = coordX;
    }

    public float getCoordY() {
        return coordY;
    }

    public void setCoordY(float coordY) {
        this.coordY = coordY;
    }
}
