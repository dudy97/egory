package com.dudy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 29.12.2018.
 */
@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "region", cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    private List<Point> points = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "group_id")
    private MountainGroup group;

    public Region() {
    }

    public Region(String name) {
        this.name = name;
    }

    public Region(String name, List<Point> points) {
        this.name = name;
        this.points = points;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public MountainGroup getGroup() {
        return group;
    }

    public void setGroup(MountainGroup group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
