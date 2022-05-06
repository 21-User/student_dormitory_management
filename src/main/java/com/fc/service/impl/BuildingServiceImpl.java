package com.fc.service.impl;

import com.fc.dao.BuildingMapper;
import com.fc.entity.Building;
import com.fc.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List findAll() {
        List<Building> data = buildingMapper.selectByExample(null);

        return data;
    }
}
