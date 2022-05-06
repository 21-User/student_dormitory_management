package com.fc.service.impl;

import com.fc.dao.DormitoryManagerMapper;
import com.fc.entity.DormitoryManager;
import com.fc.entity.DormitoryManagerExample;
import com.fc.service.DormitoryManagerService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public ResultVo<List<DormitoryManager>> findAll() {
        List<DormitoryManager> list = dormitoryManagerMapper.selectByExample(null);

        ResultVo<List<DormitoryManager>> resultVo = new ResultVo<>();

        resultVo.setData(list);

        return resultVo;
    }

    @Override
    public void addOrUpdate(String id, String name, String password, Date createTime) {
        DormitoryManager dormitoryManager = new DormitoryManager();

        dormitoryManager.setPassword(password);
        dormitoryManager.setName(name);

        if (createTime != null) {
            dormitoryManager.setCreateTime(createTime);
        }

        if (id == null) {
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
