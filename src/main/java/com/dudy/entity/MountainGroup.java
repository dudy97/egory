package com.dudy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity class of mountain groups
 */
@Entity
public class MountainGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "nazwa")
    String nazwa;

    @OneToMany(mappedBy = "group", cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    private List<Region> regions = new ArrayList<>();

    public MountainGroup() {
    }

    public MountainGroup(String nazwa) {
        this.nazwa = nazwa;
    }

    public MountainGroup(String nazwa, List<Region> regions) {
        this.nazwa = nazwa;
        this.regions = regions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
