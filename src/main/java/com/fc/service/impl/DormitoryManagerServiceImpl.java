package com.fc.service.impl;

import com.fc.dao.DormitoryManagerMapper;
import com.fc.entity.DormitoryManager;
import com.fc.entity.Student;
import com.fc.service.DormitoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.fc.service.impl.RandomNum.generateNiceString;

/**
 * @author: T21
 * @date: 2022/5/6.
 */
@Service
public class DormitoryManagerServiceImpl implements DormitoryManagerService {
    @Autowired
    private DormitoryManagerMapper managerMapper;

    @Override
    public List<DormitoryManager> findAll() {

        return managerMapper.selectByExample(null);
    }

    @Override
    public List<DormitoryManager> findByName(String name) {

        return managerMapper.findAllByName(name);
    }

    @Override
    public DormitoryManager findBySn(String sn) {
        return managerMapper.findAllBySn(sn);
    }

    @Override
    public void addOrUpdate(DormitoryManager dormitoryManager) {
        if (dormitoryManager.getId() == null) {
            //设置32位随机十六进制的id
            dormitoryManager.setId(generateNiceString());
            dormitoryManager.setCreateTime(new Date());

            managerMapper.insert(dormitoryManager);
        } else {
            managerMapper.updateByPrimaryKeySelective(dormitoryManager);

            //更新完之后查询一下返回最新的数据
            managerMapper.selectByExample(null);
        }
    }

    @Override
    public void delete(DormitoryManager dormitoryManager) {
        managerMapper.deleteByPrimaryKey(dormitoryManager.getId());
    }
}
