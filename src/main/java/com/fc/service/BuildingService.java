package com.fc.service;

import com.fc.entity.Building;

import java.util.List;

public interface BuildingService {

    List<Building> findAll();

    void addOrUpdate(Building building);

    Building findByName(String name);

    void delete(String id);
}
