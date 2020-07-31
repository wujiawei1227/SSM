package com.dao;

import com.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface roleDao {
    //根据id查询用户角色
    @Select("select * from role where id in(select roleId from users_role where userId=#{id})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "permissions",column = "id",javaType =List.class,
            many = @Many(select = "com.dao.permissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(int id) throws Exception;
    @Select("select * from role")
    List<Role> findAll() throws Exception;
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);
}
