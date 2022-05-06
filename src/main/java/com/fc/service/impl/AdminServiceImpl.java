package com.fc.service.impl;

import com.fc.dao.AdminMapper;
import com.fc.entity.Admin;
import com.fc.service.AdminService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findAll() {

        return adminMapper.selectByExample(null);
    }
}
