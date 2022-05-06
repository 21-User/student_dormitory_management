package com.fc.controller;

import com.fc.entity.DormitoryManager;
import com.fc.service.DormitoryManagerService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("dormitoryManager")
public class DormitoryManagerController {
    @Autowired
    private DormitoryManagerService dormitoryManagerService;

    @GetMapping("findByName")
    public DormitoryManager findByName(String name) {
        return dormitoryManagerService.findByName(name);
    }

    @PostMapping("findBySn")
    public DormitoryManager findBySn(String sn) {
        return dormitoryManagerService.findBySn(sn);
    }

    @GetMapping("findAll")
    public ResultVo<List<DormitoryManager>> findAll() {
        return dormitoryManagerService.findAll();
    }

    @PostMapping("addOrUpdate")
    public void addOrUpdate(String id ,
                            @RequestParam String name,
                            @RequestParam String password,
                            Date createTime) {
        dormitoryManagerService.addOrUpdate(id, name, password, createTime);
    }

    @GetMapping("delete")
    public void delete(@RequestParam String id) {
        dormitoryManagerService.delete(id);
    }
}
