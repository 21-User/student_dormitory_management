package com.fc.controller;

import com.fc.entity.DormitoryManager;
import com.fc.service.DormitoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dormitoryManager")
public class DormitoryManagerController {
    @Autowired
    private DormitoryManagerService dormitoryManagerService;

    @GetMapping("findByName")
    public DormitoryManager findByName(String name) {
        return dormitoryManagerService.findByName(name);
    }

}
