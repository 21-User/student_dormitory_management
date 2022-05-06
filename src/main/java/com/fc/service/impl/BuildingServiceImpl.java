package com.fc.service.impl;

import com.fc.dao.BuildingMapper;
import com.fc.entity.Building;
import com.fc.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.fc.service.impl.RandomNum.generateNiceString;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List<Building> findAll() {
        return buildingMapper.selectByExample(null);
    }

    @Override
    public void addOrUpdate(Building building) {
        if (building.getId() == null) {
            //设置32位随机十六进制的id
            building.setId(generateNiceString());
            building.setCreateTime(new Date());

            buildingMapper.insert(building);
        } else {
            buildingMapper.updateByPrimaryKeySelective(building);
        }
    }

    @Override
    public Building findByName(String name) {
        Building building = buildingMapper.findByName(name);

        if (building == null) {
            return null;
        }

        return building;
    }

    @Override
    public void delete(String id) {
        buildingMapper.deleteByPrimaryKey(id);
    }
}
