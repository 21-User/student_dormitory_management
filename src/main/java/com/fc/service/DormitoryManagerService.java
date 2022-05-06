package com.fc.service;

import com.fc.entity.DormitoryManager;
import com.fc.vo.ResultVo;

import java.util.Date;
import java.util.List;

public interface DormitoryManagerService {
    DormitoryManager findByName(String name);

    DormitoryManager findBySn(String sn);

    ResultVo<List<DormitoryManager>> findAll();

    void addOrUpdate(String id, String name, String password, Date createTime);

    void delete(String id);
}
