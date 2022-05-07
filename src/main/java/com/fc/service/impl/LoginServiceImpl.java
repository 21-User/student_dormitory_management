package com.fc.service.impl;

import com.fc.dao.AdminMapper;
import com.fc.dao.DormitoryManagerMapper;
import com.fc.dao.StudentMapper;
import com.fc.entity.Admin;
import com.fc.entity.DormitoryManager;
import com.fc.entity.Student;
import com.fc.service.LoginService;
import com.fc.vo.LoginVo;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private DormitoryManagerMapper managerMapper;

    @Autowired
    private StudentMapper studentMapper;

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

            //通过account找到相应的账号,得到账号类型的对象
            Admin admin = adminMapper.findAllByName(loginVo.getAccount());

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
        } else if ("2".equals(loginVo.getType())) {
            //根据输入的宿管号查询
            DormitoryManager dormitoryManager = managerMapper.findAllBySn(loginVo.getAccount());

            //如果通过宿管号没找到就通过宿管名查找
            if (dormitoryManager == null) {

                //通过宿管名查找(宿管可以重名)
                List<DormitoryManager> dormitoryManagers = managerMapper.findAllByName(loginVo.getAccount());

                //查出来的宿管名有多个说明有重名的,就是用宿管号登录(唯一)
                if (dormitoryManagers.size() > 1) {
                    resultVo.setCode("0005");
                    resultVo.setInfo(" 登录失败，请使用学号登录");

                    long time = new Date().getTime();
                    resultVo.setTimestamp(time);

                    return resultVo;
                    //通过宿管名只查到一个
                } else if (dormitoryManagers.size() == 1){
                    //获取该宿管存到dormitoryManager中得到该宿管的宿管号
                    dormitoryManager = dormitoryManagers.get(0);

                    if (!loginVo.getPassword().equals(dormitoryManager.getPassword())) {
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
                } else {
                    //宿管名和宿管号都不存在
                    resultVo.setCode("0003");
                    resultVo.setInfo("账号不存在，请您检查录入的账号信息！");

                    long time = new Date().getTime();
                    resultVo.setTimestamp(time);

                    return resultVo;
                }
                //使用,根据宿管名查到的宿管号登录
            } else {

                if (!loginVo.getPassword().equals(dormitoryManager.getPassword())) {
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
        } else if ("3".equals(loginVo.getType())) {
            //根据输入的学号查询
            Student student = studentMapper.findAllBySn(loginVo.getAccount());
            //如果通过学号没找到就通过学生名查找
            if (student == null) {

                //通过学号查找(学生可以重名)
                List<Student> students = studentMapper.findAllByName(loginVo.getAccount());

                //查出来的学生名有多个说明有重名的,就是用学号登录(唯一)
                if (students.size() > 1) {
                    resultVo.setCode("0005");
                    resultVo.setInfo(" 登录失败，请使用学号登录");

                    long time = new Date().getTime();
                    resultVo.setTimestamp(time);

                    return resultVo;
                    //通过学名只查到一个
                } else if (students.size() == 1){
                    student = students.get(0);
                    if (!loginVo.getPassword().equals(student.getPassword())) {
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
                } else {
                    //学生名和学号都不存在
                    resultVo.setCode("0003");
                    resultVo.setInfo("账号不存在，请您检查录入的账号信息！");

                    long time = new Date().getTime();
                    resultVo.setTimestamp(time);

                    return resultVo;
                }
                //使用,根据学生名查到的学号登录
            } else {

                if (!loginVo.getPassword().equals(student.getPassword())) {
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
