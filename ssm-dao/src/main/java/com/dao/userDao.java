package com.dao;

import com.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface userDao {
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "com.dao.roleDao.findRoleByUserId")) })
    public UserInfo findById(int id) throws Exception;

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "com.dao.roleDao.findRoleByUserId")) })
    public UserInfo findByName(String name) throws Exception;

    @Select("select * from users")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "com.dao.roleDao.findRoleByUserId")) })
    public List<UserInfo> findAll() throws  Exception;

    @Insert("insert into users (email,username,password,phoneNum,status) value(#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(UserInfo userInfo);
    @Insert("insert into users_role(userId,roleId) value(#{userId},#{roleId})")
    public void addRoleToUser(@Param("userId") int userId,@Param("roleId")int roleId);
}
