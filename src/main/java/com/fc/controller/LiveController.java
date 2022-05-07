package com.fc.controller;

import com.fc.dao.LiveMapper;
import com.fc.entity.Live;
import com.fc.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: T21
 * @date: 2022/5/7.
 */
@RestController
@RequestMapping("live")
public class LiveController {
    @Autowired
    private LiveService liveService;

    @GetMapping("findAll")
    public List<Live> findAll() {

        return liveService.findAll();
    }

    @PostMapping("addOrUpdate")
    public void addOrUpdate(@RequestBody Live live) {
        liveService.addOrUpdate(live);
    }

    @GetMapping("delete")
    public void delete(String id) {
        liveService.delete(id);
    }
}
