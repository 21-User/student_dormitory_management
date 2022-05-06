package com.fc.service.impl;

import com.fc.dao.DormitoryManagerMapper;
import com.fc.entity.DormitoryManager;
import com.fc.entity.DormitoryManagerExample;
import com.fc.service.DormitoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormitoryManagerServiceImpl implements DormitoryManagerService {
    @Autowired
    @Qualifier(value = "dormitoryManagerMapper")
    private DormitoryManagerMapper dormitoryManagerMapper;

    @Override
    public DormitoryManager findByName(String name) {
        DormitoryManagerExample dormitoryManagerExample = new DormitoryManagerExample();

        DormitoryManagerExample.Criteria criteria = dormitoryManagerExample.createCriteria();

        criteria.andNameEqualTo(name);

        List<DormitoryManager> managers = dormitoryManagerMapper.selectByExample(dormitoryManagerExample);

        if (managers == null) {
            return null;
        }

        return managers.get(0);
    }
}
