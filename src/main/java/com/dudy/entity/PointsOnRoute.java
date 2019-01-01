package com.dudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by admin on 01.01.2019.
 */
@Entity(name = "PuntyTrasy")
public class PointsOnRoute implements Serializable{
    @Id
    @Column(name = "idP")
    int pointId;

    @Id
    @Column(name = "idT")
    int routeId;

    public PointsOnRoute() {
    }

    public PointsOnRoute(int pointId, int routeId) {
        this.pointId = pointId;
        this.routeId = routeId;
    }

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }
}
