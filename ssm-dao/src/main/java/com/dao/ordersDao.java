package com.dao;

import com.domain.Orders;

import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: wudaren
 * @create: 2020-07-27 17:27
 **/

public interface ordersDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select = "com.dao.productDao.findById")),
    })
   public List<Orders> findAll() throws Exception;
@Select("select * from orders where id=#{id}")
@Results({
        @Result(id = true,column = "id",property = "id"),
        @Result(column = "orderNum",property = "orderNum"),
        @Result(column = "orderTime",property = "orderTime"),
        @Result(column = "orderStatus",property = "orderStatus"),
        @Result(column = "peopleCount",property = "peopleCount"),
        @Result(column = "payType",property = "payType"),
        @Result(column = "orderDesc",property = "orderDesc"),
        @Result(column = "productId",property = "product",one = @One(select = "com.dao.productDao.findById")),
        @Result(column = "id",property = "travellers",many = @Many(select = "com.dao.travellerDao.findByOrdersId")),
        @Result(column = "memberId",property = "member",one = @One(select = "com.dao.memberDao.findById")),
})
   public Orders findById(String id);
}
