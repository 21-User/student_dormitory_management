package com.fc.service;

import com.fc.vo.LoginVo;
import com.fc.vo.ResultVo;

import javax.servlet.http.HttpSession;

public interface LoginService {
    ResultVo<Object> login(LoginVo loginVo, HttpSession session);

}