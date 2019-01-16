package com.dudy.repository;

import com.dudy.entity.Point;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by admin on 12.12.2018.
 */
public interface PointRepository extends CrudRepository<Point , Integer>{
    @Query(value = "select * from Punty_Trasy pt join Point p on pt.idp=p.id where pt.idt=:theId", nativeQuery = true)
    public List<Point> getPointsByRoute(@Param("theId") int theId);
    Point findByName(String name);
}
