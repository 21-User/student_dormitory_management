package com.fc.service;

import com.fc.entity.DormitoryManager;
import com.fc.entity.Student;

import java.util.List;

/**
 * @author: T21
 * @date: 2022/5/6.
 */
public interface DormitoryManagerService{
    List<DormitoryManager> findAll();

    List<DormitoryManager> findByName(String name);

    DormitoryManager findBySn(String sn);

    void addOrUpdate(DormitoryManager dormitoryManager);

    void delete(DormitoryManager dormitoryManager);
}
