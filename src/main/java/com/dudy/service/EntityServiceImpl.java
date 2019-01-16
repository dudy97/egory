package com.dudy.service;

import com.dudy.entity.MountainGroup;
import com.dudy.entity.Point;
import com.dudy.entity.Region;
import com.dudy.entity.Route;
import com.dudy.repository.MountainGroupRepository;
import com.dudy.repository.PointRepository;
import com.dudy.repository.RegionRepository;
import com.dudy.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15.01.2019.
 */
@Service
public class EntityServiceImpl implements EntityService{
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private PointRepository pointRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private MountainGroupRepository mountainGroupRepository;

    public List<Region> findAllRegions(){
       return (List<Region>) regionRepository.findAll();
    }

    @Override
    public void savePoint(Point point) {
        pointRepository.save(point);
    }

    @Override
    public List<MountainGroup> findAllMountainGroups() {
        return (List<MountainGroup>) mountainGroupRepository.findAll();
    }

    @Override
    public List<Route> getRouteByGroup(String groupName) {
        return routeRepository.getRoutesByGroup(groupName);
    }

    @Override
    public List<Point> getPointsByRoute(int routeId) {
        return (List<Point>) pointRepository.getPointsByRoute(routeId);
    }

    @Override
    public List<Point> getPoints() {
        return (List<Point>) pointRepository.findAll();
    }
}
