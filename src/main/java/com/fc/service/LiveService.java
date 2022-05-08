package com.fc.service;

import com.fc.entity.Live;

import java.util.List;

public interface LiveService {
    List<Live> findAll();

    void addOrUpdate(Live live);

    void delete(String id);
}
