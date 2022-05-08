package com.fc.controller;

import com.fc.service.LoginService;
import com.fc.vo.LoginVo;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.Date;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public ResultVo<Object> login(@RequestBody LoginVo loginVo, HttpSession session) {

        return loginService.login(loginVo, session);
    }

    @PostMapping("logout")
    public ResultVo<Object> logout(@RequestBody LoginVo loginVo, HttpSession session) {

        ResultVo<Object> vo = new ResultVo<>();

        vo.setRequestId(loginVo.getRequestId());
        vo.setOperator(loginVo.getOperator());
        vo.setTimestamp(System.currentTimeMillis());
        vo.setCode("0000");
        vo.setInfo("退出成功");

        session.setAttribute("user", null);
        session.setAttribute("userType", null);

        return vo;
    }

}
