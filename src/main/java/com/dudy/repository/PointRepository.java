package com.dudy.repository;

import com.dudy.entity.Point;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by admin on 12.12.2018.
 */
public interface PointRepository extends CrudRepository<Point , Integer>{
}
