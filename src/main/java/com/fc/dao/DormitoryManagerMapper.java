package com.fc.dao;

import com.fc.entity.DormitoryManager;
import com.fc.entity.DormitoryManagerExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DormitoryManagerMapper {
    long countByExample(DormitoryManagerExample example);

    int deleteByExample(DormitoryManagerExample example);

    int deleteByPrimaryKey(String id);

    int insert(DormitoryManager record);

    int insertSelective(DormitoryManager record);

    List<DormitoryManager> selectByExample(DormitoryManagerExample example);

    DormitoryManager selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DormitoryManager record, @Param("example") DormitoryManagerExample example);

    int updateByExample(@Param("record") DormitoryManager record, @Param("example") DormitoryManagerExample example);

    int updateByPrimaryKeySelective(DormitoryManager record);

    int updateByPrimaryKey(DormitoryManager record);

    DormitoryManager findAllBySn(String account);

    List<DormitoryManager> findAllByName(String account);
}