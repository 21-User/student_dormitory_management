package com.fc.controller;

import com.fc.entity.Student;
import com.fc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @PostMapping("addOrUpdate")
    public void addOrUpdate(@RequestBody Student student) {
        studentService.addOrUpdate(student);
    }

    @GetMapping("findBySn")
    public Student findBySn(String sn) {
        return studentService.findBySn(sn);
    }

    @GetMapping("findByName")
    public List<Student> findByName(String name) {

        return studentService.findByName(name);
    }

    @GetMapping("delete")
    public void delete(Student student) {
        studentService.delete(student);
    }
}
