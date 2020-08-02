package com.dao;

import com.domain.Permission;
import com.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface permissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
    @Select("select * from permission where id=#{id}")
    public Permission findById(int id);
    @Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findOtherPermission(int id);
}
