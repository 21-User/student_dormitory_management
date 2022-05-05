package com.fc.service.impl;

import com.fc.dao.AdminMapper;
import com.fc.entity.Admin;
import com.fc.service.LoginService;
import com.fc.vo.LoginVo;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 验证码有效时间
     * 60秒
     */
    private static final long cpachaTimeout = 86400000;

    @Override
    public ResultVo<Object> login(LoginVo loginVo, HttpSession session) {
        ResultVo<Object> resultVo = new ResultVo<>();
        //设置返回对象的请求id,操作人
        resultVo.setRequestId(loginVo.getRequestId());
        resultVo.setOperator(loginVo.getOperator());

        //通过account找到相应的账号,得到账号类型的对象
        Admin admin = adminMapper.findAllByName(loginVo.getAccount());








        //验证码校验
        Object cpacha = session.getAttribute("cpacha");
        //校验session数据是否失效
        if (null == cpacha || !StringUtils.hasLength(String.valueOf(cpacha))) {
            //验证码已失效
            resultVo.setCode("0002");
            resultVo.setInfo("验证码已失效");

            long time = new Date().getTime();
            resultVo.setTimestamp(time);
            return resultVo;
        } else {
            String[] cpachaCode = cpacha.toString().split("_");
            long time = Long.parseLong(cpachaCode[1]);
            long now = System.currentTimeMillis();
            if (now - time > cpachaTimeout) {
                //验证码已过期
                resultVo.setCode("0002");
                resultVo.setInfo("验证码已过期");

                long timestamp = new Date().getTime();
                resultVo.setTimestamp(timestamp);

                return resultVo;
            }
            // 设置不区分大小写
            if (!loginVo.getCaptcha().toUpperCase().equals(cpachaCode[0].toUpperCase())) {
                //验证码输入错误
                resultVo.setCode("0002");
                resultVo.setInfo("验证码输入错误");

                long timestamp = new Date().getTime();
                resultVo.setTimestamp(timestamp);

                return resultVo;
            }
        }






        //type为1管理员
        if ("1".equals(loginVo.getType())) {
            //如果对象不存在
            if (admin == null) {
                resultVo.setCode("0003");
                resultVo.setInfo("账号不存在，请您检查录入的账号信息！");

                long time = new Date().getTime();
                resultVo.setTimestamp(time);

                return resultVo;
            } else {
                //判断密码是否正确
                if ( !loginVo.getPassword().equals(admin.getPassword()) ) {
                    resultVo.setCode("0004");
                    resultVo.setInfo("密码错误，如需重置密码请联系管理员！");

                    long time = new Date().getTime();
                    resultVo.setTimestamp(time);

                    return resultVo;
                } else {
                    //密码正确
                    resultVo.setCode("0000");
                    long time = new Date().getTime();
                    resultVo.setTimestamp(time);

                    //登录成功，存入Session域键为user，值为account，键为userType,值为type；
                    session.setAttribute("user", loginVo.getAccount());
                    session.setAttribute("userType", loginVo.getType());

                    return resultVo;
                }
            }
        }


        return resultVo;
    }
}
