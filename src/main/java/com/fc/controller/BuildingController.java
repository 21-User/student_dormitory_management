package com.fc.controller;

import com.fc.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;
    @ResponseBody
    @GetMapping("findAll")
    public List findAll() {
        return buildingService.findAll();
    }
}
