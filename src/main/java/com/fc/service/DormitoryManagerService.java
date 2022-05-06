package com.fc.service;

import com.fc.entity.DormitoryManager;

public interface DormitoryManagerService {
    DormitoryManager findByName(String name);
}
