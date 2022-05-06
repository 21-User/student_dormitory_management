package com.fc.service;

import com.fc.entity.Dormitory;

import java.util.List;

public interface DormitoryService {
    List findAll();

    Dormitory findBySn(String sn);

    void delete(String id);

    void addOrUpdate(Dormitory dormitory);
}
