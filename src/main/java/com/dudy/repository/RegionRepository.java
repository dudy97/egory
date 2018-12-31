package com.dudy.repository;

import com.dudy.entity.Point;
import com.dudy.entity.Region;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by admin on 31.12.2018.
 */
public interface RegionRepository extends CrudRepository<Region, Integer> {
}
