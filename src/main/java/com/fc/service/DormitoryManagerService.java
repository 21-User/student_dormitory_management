package com.fc.service;

import com.fc.entity.DormitoryManager;
import com.fc.vo.ResultVo;

import java.util.Date;
import java.util.List;

public interface DormitoryManagerService {
    DormitoryManager findByName(String name);

    DormitoryManager findBySn(String sn);

    List findAll();

    void addOrUpdate(String id, String name, String password, Date createTime, String sex, String sn);

    void delete(String id);
}
