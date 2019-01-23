package com.dudy.repository;

import com.dudy.entity.Point;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository of Point
 */
public interface PointRepository extends CrudRepository<Point , Integer>{
    /**
     * @param theId Id of the point, that we want to find
     * @return List of points found
     */
    @Query(value = "select * from Punty_Trasy pt join Point p on pt.idp=p.id where pt.idt=:theId", nativeQuery = true)
    public List<Point> getPointsByRoute(@Param("theId") int theId);
    /**
     * @param name Name of the point, that we want to find
     */
    Point findByName(String name);
}
