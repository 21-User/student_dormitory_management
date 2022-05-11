package com.fc.controller;

import com.fc.entity.Dormitory;
import com.fc.service.DormitoryService;
import com.fc.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dormitory")
public class DormitoryController {
    @Autowired
    private DormitoryService dormitoryService;

    @ResponseBody
    @GetMapping("findAll")
    public List findAll() {
        return dormitoryService.findAll();
    }

    @GetMapping("findBySn")
    public Dormitory findBySn(String sn) {
        return dormitoryService.findBySn(sn);
    }

    @GetMapping("delete")
    public DataVO delete(String id) {
        return dormitoryService.delete(id);
    }

    @PostMapping("addOrUpdate")
    public void addOrUpdate(@RequestBody Dormitory dormitory) {
        dormitoryService.addOrUpdate(dormitory);
    }
}
