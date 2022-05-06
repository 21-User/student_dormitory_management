package com.fc.service;

import com.fc.entity.Building;

import java.util.List;

/**
 * @author: T21
 * @date: 2022/5/6.
 */
public interface BuildingService {
    List<Building> findAll();

    void addOrUpdate(Building building);

    Building findByName(String name);

    void delete(String id);
}
