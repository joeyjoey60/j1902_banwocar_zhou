package com.joey.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.AdminUserLogin;
import pojo.AdminUserLoginExample;

import java.util.List;

@Mapper
public interface AdminUserLoginMapper {
    int countByExample(AdminUserLoginExample example);

    int deleteByExample(AdminUserLoginExample example);

    int insert(AdminUserLogin record);

    int insertSelective(AdminUserLogin record);

    List<AdminUserLogin> selectByExample(AdminUserLoginExample example);

    int updateByExampleSelective(@Param("record") AdminUserLogin record, @Param("example") AdminUserLoginExample example);

    int updateByExample(@Param("record") AdminUserLogin record, @Param("example") AdminUserLoginExample example);
}