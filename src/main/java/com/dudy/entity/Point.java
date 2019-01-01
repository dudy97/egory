package com.dudy.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 12.12.2018.
 */

@Entity
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "is required")
    @NotBlank
    @Column(name = "nazwa")
    private String name;

    @Column(name = "wysokosc")
    @NotNull(message = "is required")
    @Min(0)
    private int height;

    @Column(name = "dl_geo")
    @NotNull(message = "is required")
    @Min(-180)
    @Max(180)
    private double longitude;

    @Column(name = "szer_geo")
    @NotNull(message = "is required")
    @Min(-90)
    @Max(90)
    private double latitude;

    @Column(name = "opis")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "PunktyTrasy",
            joinColumns = @JoinColumn(name="idP"),
            inverseJoinColumns = @JoinColumn(name = "idT"))
    private List<Route> routes = new ArrayList<>();

    public Point() {
    }

    public Point(String name, int height, double longitude, double latitude, String description) {
        this.name = name;
        this.height = height;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
    }

    public Point(String name, int height, double longitude, double latitude, String description, Region region) {
        this.name=name;
        this.height = height;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
        this.region=region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", description='" + description + '\'' +
                '}';
    }
}
