package com.fc.service.impl;

import com.fc.dao.StudentMapper;
import com.fc.entity.Student;
import com.fc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.fc.service.impl.RandomNum.generateNiceString;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return studentMapper.selectByExample(null);
    }

    @Override
    public void addOrUpdate(Student student) {
        if (student.getId() == null) {
            //设置32位随机十六进制的id
            student.setId(generateNiceString());
            student.setCreateTime(new Date());

            studentMapper.insert(student);
        } else {
            studentMapper.updateByPrimaryKeySelective(student);

            //更新完之后查询一下返回最新的数据
            studentMapper.selectByExample(null);
        }
    }

    @Override
    public Student findBySn(String sn) {

        return studentMapper.findAllBySn(sn);
    }

    @Override
    public List<Student> findByName(String name) {

        return studentMapper.findAllByName(name);
    }

    @Override
    public void delete(Student student) {
        studentMapper.deleteByPrimaryKey(student.getId());
    }

}
