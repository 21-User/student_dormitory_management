package com.fc.service.impl;

import com.fc.dao.LiveMapper;
import com.fc.entity.Live;
import com.fc.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.fc.service.impl.RandomNum.generateNiceString;

/**
 * @author: T21
 * @date: 2022/5/7.
 */
@Service
public class LiveServiceImpl implements LiveService {
    @Autowired
    private LiveMapper liveMapper;

    @Override
    public List<Live> findAll() {

        return liveMapper.selectByExample(null);
    }

    @Override
    public void addOrUpdate(Live live) {

        if (live.getId() == null) {
            //生成
            live.setId(generateNiceString());
            live.setCreateTime(new Date());

            liveMapper.insertSelective(live);
        } else {
            liveMapper.updateByPrimaryKeySelective(live);
        }
    }

    @Override
    public void delete(String id) {
        liveMapper.deleteByPrimaryKey(id);
    }
}
