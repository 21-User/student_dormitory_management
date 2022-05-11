package com.fc.controller;

import com.fc.entity.DormitoryManager;
import com.fc.service.DormitoryManagerService;
import com.fc.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("dormitoryManager")
public class DormitoryManagerController {
    @Autowired
    private DormitoryManagerService dormitoryManagerService;
    @ResponseBody
    @GetMapping("findByName")
    public DormitoryManager findByName(String name) {
        return dormitoryManagerService.findByName(name);
    }
    @ResponseBody
    @GetMapping("findBySn")
    public DormitoryManager findBySn(String sn) {
        return dormitoryManagerService.findBySn(sn);
    }

    @GetMapping("findAll")
    public List findAll() {
        return dormitoryManagerService.findAll();
    }


    @PostMapping ("addOrUpdate")
    public void addOrUpdate(@RequestBody DormitoryManager dormitoryManager) {
        dormitoryManagerService.addOrUpdate(dormitoryManager.getId(), dormitoryManager.getName(), dormitoryManager.getPassword(), dormitoryManager.getCreateTime(), dormitoryManager.getSex(), dormitoryManager.getSn());
    }

    @GetMapping("delete")
    public DataVO delete(String id) {
        return dormitoryManagerService.delete(id);
    }
}
