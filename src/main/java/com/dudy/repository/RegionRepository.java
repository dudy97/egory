package com.dudy.repository;

import com.dudy.entity.Point;
import com.dudy.entity.Region;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD operations on Region
 */
public interface RegionRepository extends CrudRepository<Region, Integer> {
}
