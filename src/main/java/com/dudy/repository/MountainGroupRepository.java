package com.dudy.repository;

import com.dudy.entity.MountainGroup;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD operations on MountainGroup
 */
public interface MountainGroupRepository extends CrudRepository<MountainGroup, Integer> {
}
