package com.dudy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 01.01.2019.
 */
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="szlak")
    String name;

    @Column(name="punkty_za_trase")
    int pointsForRoute;

    @Column(name="dlugosc_trasy")
    double routeLength;

    @Column(name="roznica_wysokosci")
    int heightDiffrence;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "PunktyTrasy",
    joinColumns = @JoinColumn(name="idT"),
    inverseJoinColumns = @JoinColumn(name = "idP"))
    private List<Point> points = new ArrayList<>();

    public Route() {
    }

    public Route(String name, int pointsForRoute, double routeLength, int heightDiffrence) {
        this.name = name;
        this.pointsForRoute = pointsForRoute;
        this.routeLength = routeLength;
        this.heightDiffrence = heightDiffrence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPointsForRoute() {
        return pointsForRoute;
    }

    public void setPointsForRoute(int pointsForRoute) {
        this.pointsForRoute = pointsForRoute;
    }

    public double getRouteLength() {
        return routeLength;
    }

    public void setRouteLength(double routeLength) {
        this.routeLength = routeLength;
    }

    public int getHeightDiffrence() {
        return heightDiffrence;
    }

    public void setHeightDiffrence(int heightDiffrence) {
        this.heightDiffrence = heightDiffrence;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pointsForRoute=" + pointsForRoute +
                ", routeLength=" + routeLength +
                ", heightDiffrence=" + heightDiffrence +
                '}';
    }
}
