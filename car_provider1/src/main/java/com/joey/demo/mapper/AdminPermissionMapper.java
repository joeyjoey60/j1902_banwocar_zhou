package com.joey.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.AdminPermission;
import pojo.AdminPermissionExample;

@Mapper
public interface AdminPermissionMapper {
    int countByExample(AdminPermissionExample example);

    int deleteByExample(AdminPermissionExample example);

    int deleteByPrimaryKey(Integer permissionId);

    int insert(AdminPermission record);

    int insertSelective(AdminPermission record);

    List<AdminPermission> selectByExample(AdminPermissionExample example);

    AdminPermission selectByPrimaryKey(Integer permissionId);

    int updateByExampleSelective(@Param("record") AdminPermission record, @Param("example") AdminPermissionExample example);

    int updateByExample(@Param("record") AdminPermission record, @Param("example") AdminPermissionExample example);

    int updateByPrimaryKeySelective(AdminPermission record);

    int updateByPrimaryKey(AdminPermission record);

    public List<AdminPermission> findPermissionByLoginName(@Param("username") String username);
}