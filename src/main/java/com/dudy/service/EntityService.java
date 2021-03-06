package com.dudy.service;

import com.dudy.entity.MountainGroup;
import com.dudy.entity.Point;
import com.dudy.entity.Region;
import com.dudy.entity.Route;

import java.util.List;

/**
 * Class which use entity repository
 */
public interface EntityService {
    public List<Region> findAllRegions();
    void savePoint(Point point);
    List<MountainGroup> findAllMountainGroups();
    List<Route> getRouteByGroup(String groupName);
    List<Point> getPointsByRoute(int routeId);
    List<Point> getPoints();
}
