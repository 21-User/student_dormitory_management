package com.fc.controller;

import com.fc.service.LoginService;
import com.fc.vo.LoginVo;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public ResultVo<Object> login(@RequestBody LoginVo loginVo, HttpSession session) {

        return loginService.login(loginVo, session);
    }
}
