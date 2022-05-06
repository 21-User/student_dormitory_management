package com.fc.service.impl;

import com.fc.dao.AdminMapper;
import com.fc.entity.Admin;
import com.fc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.fc.service.impl.RandomNum.generateNiceString;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findAll() {

        return adminMapper.selectByExample(null);
    }

    @Override
    public void addOrUpdate(Admin admin) {

        if (admin.getId() == null) {
            //设置32位随机十六进制的id
            admin.setId(generateNiceString());
            admin.setCreateTime(new Date());

            adminMapper.insert(admin);
        } else {
            adminMapper.updateByPrimaryKeySelective(admin);

            //更新完之后查询一下返回最新的数据
            adminMapper.selectByExample(null);
        }
    }

    @Override
    public Admin findByName(String name) {
        Admin admin = adminMapper.findAllByName(name);

        if (admin == null) {
            return null;
        }

        return admin;
    }

    @Override
    public void delete(Admin admin) {
        adminMapper.deleteByPrimaryKey(admin.getId());
    }
}
