package com.fc.service;

import com.fc.entity.Dormitory;
import com.fc.vo.DataVO;

import java.util.List;

public interface DormitoryService {
    List findAll();

    Dormitory findBySn(String sn);

    DataVO delete(String id);

    void addOrUpdate(Dormitory dormitory);
}
