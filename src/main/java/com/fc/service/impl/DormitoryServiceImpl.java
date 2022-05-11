package com.fc.service.impl;

import com.fc.dao.DormitoryMapper;
import com.fc.dao.LiveMapper;
import com.fc.entity.*;
import com.fc.service.DormitoryService;
import com.fc.util.RandomNum;
import com.fc.vo.DataVO;
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
    public DataVO delete(String id) {
        LiveExample liveExample = new LiveExample();

        LiveExample.Criteria criteria = liveExample.createCriteria();

        criteria.andDormitoryIdEqualTo(id);

        List<Live> lives = liveMapper.selectByExample(liveExample);

        DataVO dataVO = null;

        if (lives.size() == 0 || lives == null) {
            dormitoryMapper.deleteByPrimaryKey(id);

            dataVO = new DataVO(200, "删除宿舍成功", true);
        } else {
            dataVO = new DataVO(400, "宿舍有人，无法删除", false);
        }

        return dataVO;
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
