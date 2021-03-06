package com.fc.controller;

import com.fc.service.BuildingService;
import com.fc.vo.BuildingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @GetMapping("findAll")
    public List<BuildingVO> findAll() {
        return buildingService.findAll();
    }
}
