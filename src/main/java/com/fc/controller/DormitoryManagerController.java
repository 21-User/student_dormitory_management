package com.fc.controller;

import com.fc.service.DormitoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dormitoryManager")
public class DormitoryManagerController {
    @Autowired
    private DormitoryManagerService dormitoryManagerService;


}
