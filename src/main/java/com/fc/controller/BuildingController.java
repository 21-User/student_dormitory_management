package com.fc.controller;

import com.fc.entity.Building;
import com.fc.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: T21
 * @date: 2022/5/6.
 */
@RestController
@RequestMapping("building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @GetMapping("findAll")
    public List<Building> findAll() {

        return buildingService.findAll();
    }

    @PostMapping("addOrUpdate")
    public void addOrUpdate(@RequestBody Building building) {
        buildingService.addOrUpdate(building);
    }

    @GetMapping("findByName")
    public Building findByName(String name) {

        return buildingService.findByName(name);
    }

    @GetMapping("delete")
    public void delete(String id) {
        buildingService.delete(id);
    }
}
