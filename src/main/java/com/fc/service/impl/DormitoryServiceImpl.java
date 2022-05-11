package com.fc.service.impl;

import com.fc.dao.BuildingMapper;
import com.fc.dao.DormitoryMapper;
import com.fc.dao.LiveMapper;
import com.fc.entity.*;
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

    @Autowired
    private LiveMapper liveMapper;

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
    public boolean delete(String id) {
        LiveExample liveExample = new LiveExample();

        LiveExample.Criteria criteria = liveExample.createCriteria();

        criteria.andDormitoryIdEqualTo(id);

        List<Live> lives = liveMapper.selectByExample(liveExample);

        if (lives.size() == 0 || lives == null) {
            dormitoryMapper.deleteByPrimaryKey(id);
            return true;
        }

        return false;
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
