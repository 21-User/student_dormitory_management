package com.fc.service.impl;

import com.fc.dao.DormitoryManagerMapper;
import com.fc.entity.DormitoryManager;
import com.fc.entity.DormitoryManagerExample;
import com.fc.service.DormitoryManagerService;
import com.fc.util.RandomNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DormitoryManagerServiceImpl implements DormitoryManagerService {
    @Autowired
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

    @Override
    public DormitoryManager findBySn(String sn) {
        DormitoryManagerExample dormitoryManagerExample = new DormitoryManagerExample();

        DormitoryManagerExample.Criteria criteria = dormitoryManagerExample.createCriteria();

        criteria.andSnEqualTo(sn);

        List<DormitoryManager> managers = dormitoryManagerMapper.selectByExample(dormitoryManagerExample);

        if (managers == null) {
            return null;
        }

        return managers.get(0);
    }

    @Override
    public List findAll() {
        List<DormitoryManager> data = dormitoryManagerMapper.selectByExample(null);


        return data;
    }

    @Override
    public void addOrUpdate(String id, String name, String password, Date createTime, String sex, String sn) {
        DormitoryManager dormitoryManager = new DormitoryManager();

        dormitoryManager.setPassword(password);
        dormitoryManager.setName(name);
        dormitoryManager.setSex(sex);
        dormitoryManager.setSn(sn);


        if (createTime != null) {
            dormitoryManager.setCreateTime(createTime);
        }

        if (id == null) {
            dormitoryManager.setId(RandomNum.generateNiceString());
            dormitoryManagerMapper.insertSelective(dormitoryManager);

        } else {
            dormitoryManager.setId(id);
            dormitoryManagerMapper.updateByPrimaryKeySelective(dormitoryManager);
        }
    }

    @Override
    public void delete(String id) {
        dormitoryManagerMapper.deleteByPrimaryKey(id);
    }
}
