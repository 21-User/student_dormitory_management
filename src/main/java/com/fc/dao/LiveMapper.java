package com.fc.dao;

import com.fc.entity.Live;
import com.fc.entity.LiveExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface LiveMapper {
    long countByExample(LiveExample example);

    int deleteByExample(LiveExample example);

    int deleteByPrimaryKey(String id);

    int insert(Live record);

    int insertSelective(Live record);

    List<Live> selectByExample(LiveExample example);

    Live selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Live record, @Param("example") LiveExample example);

    int updateByExample(@Param("record") Live record, @Param("example") LiveExample example);

    int updateByPrimaryKeySelective(Live record);

    int updateByPrimaryKey(Live record);

}