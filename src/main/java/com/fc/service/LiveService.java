package com.fc.service;

import com.fc.entity.Live;

import java.util.List;

/**
 * @author: T21
 * @date: 2022/5/7.
 */
public interface LiveService {
    List<Live> findAll();

    void addOrUpdate(Live live);

    void delete(String id);
}
