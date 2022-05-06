package com.fc.service.impl;

import com.fc.dao.BuildingMapper;
import com.fc.dao.DormitoryMapper;
import com.fc.entity.Building;
import com.fc.entity.Dormitory;
import com.fc.entity.DormitoryExample;
import com.fc.entity.DormitoryManager;
import com.fc.service.DormitoryService;
import com.fc.util.RandomNum;
import com.fc.vo.DormitoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DormitoryServiceImpl implements DormitoryService {
    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public List findAll() {
        List<DormitoryVO> date = dormitoryMapper.findAll();

        return date;
    }

    @Override
    public Dormitory findBySn(String sn) {
        DormitoryExample dormitoryExample = new DormitoryExample();

        DormitoryExample.Criteria criteria = dormitoryExample.createCriteria();

        criteria.andSnEqualTo(sn);

        List<Dormitory> dormitories = dormitoryMapper.selectByExample(dormitoryExample);

        if (dormitories == null || dormitories.size() == 0) {
            return null;
        }
        return dormitories.get(0);
    }


    @Override
    public void delete(String id) {
        dormitoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addOrUpdate(Dormitory dormitory) {
        if (dormitory.getId() == null) {

            dormitory.setCreateTime(new Date());

            dormitory.setId(RandomNum.generateNiceString());

            dormitoryMapper.insertSelective(dormitory);

        } else {
            dormitoryMapper.updateByPrimaryKeySelective(dormitory);
        }
    }


}
