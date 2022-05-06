package com.fc.controller;

import com.fc.entity.Admin;
import com.fc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("findAll")
    public List<Admin> findAll() {

        return adminService.findAll();
    }

    @PostMapping("addOrUpdate")
    public void addOrUpdate(@RequestBody Admin admin) {
        adminService.addOrUpdate(admin);
    }

    @GetMapping("findByName")
    public Admin findByName(String name) {
        return adminService.findByName(name);
    }

    @GetMapping("delete")
    public void delete(Admin admin) {
        adminService.delete(admin);
    }
}
