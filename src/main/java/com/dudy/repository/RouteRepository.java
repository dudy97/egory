package com.dudy.repository;

import com.dudy.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 02.01.2019.
 */

public interface RouteRepository extends JpaRepository<Route,Integer>{
    //@Query(value = "SELECT name from Routes r join PointsOnRoute por on r.id=por.idt join Point p on por.idp=p.id join Region reg on p.region_id=reg.id join MountainGroup mg on reg.group_id=mg.id where mg.nazwa=group")

    @Query(value = "SELECT * from Route r inner join Punty_Trasy por on r.id=por.idt join Point p on por.idp=p.id join Region reg on p.region_id=reg.id join Mountain_Group mg on reg.group_id=mg.id where mg.nazwa=:groupName", nativeQuery = true)
    public ArrayList<Route> getRoutesByGroup(@Param("groupName") String groupName);

}
