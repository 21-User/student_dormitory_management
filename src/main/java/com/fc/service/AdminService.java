package com.fc.service;

import com.fc.entity.Admin;
import com.fc.vo.ResultVo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface AdminService {
    List<Admin> findAll();

    void addOrUpdate(Admin admin);

    Admin findByName(String name);

    void delete(Admin admin);
}
