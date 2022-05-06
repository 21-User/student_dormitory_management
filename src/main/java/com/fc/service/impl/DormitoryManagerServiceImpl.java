package com.fc.service.impl;

import com.fc.dao.DormitoryManagerMapper;
import com.fc.entity.DormitoryManager;
import com.fc.service.DormitoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormitoryManagerServiceImpl implements DormitoryManagerService {
    @Autowired
    private DormitoryManagerMapper managerMapper;


    @Override
    public List<DormitoryManager> findAll() {
        return managerMapper.selectByExample(null);
    }
}
