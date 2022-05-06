package com.fc.controller;

import com.fc.entity.Admin;
import com.fc.service.AdminService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("findAll")
    @ResponseBody
    public List<Admin> findAll() {

        return adminService.findAll();
    }
}
