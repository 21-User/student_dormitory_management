package com.fc.controller;

import com.fc.dao.DormitoryManagerMapper;
import com.fc.entity.DormitoryManager;
import com.fc.entity.Student;
import com.fc.service.DormitoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: T21
 * @date: 2022/5/6.
 */
@RestController
@RequestMapping("dormitoryManager")
public class DormitoryManagerController {
    @Autowired
    private DormitoryManagerService managerService;

    @GetMapping("findAll")
    public List<DormitoryManager> findAll() {
        return managerService.findAll();
    }

    @GetMapping("findByName")
    public List<DormitoryManager> findByName(String name) {

        return managerService.findByName(name);
    }

    @GetMapping("findBySn")
    public DormitoryManager findBySn(String sn) {
        return managerService.findBySn(sn);
    }

    @PostMapping("addOrUpdate")
    public void addOrUpdate(@RequestBody DormitoryManager dormitoryManager) {
        managerService.addOrUpdate(dormitoryManager);
    }

    @GetMapping("delete")
    public void delete(DormitoryManager dormitoryManager) {
        managerService.delete(dormitoryManager);
    }
}
