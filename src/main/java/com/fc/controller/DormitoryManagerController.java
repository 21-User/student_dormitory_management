package com.fc.controller;

import com.fc.entity.DormitoryManager;
import com.fc.service.DormitoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dormitoryManager")
public class DormitoryManagerController {
    @Autowired
    private DormitoryManagerService managerService;

    @GetMapping("findAll")
    public List<DormitoryManager> findAll() {
        return managerService.findAll();
    }
}
