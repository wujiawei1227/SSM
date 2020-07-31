package com.dao;

import com.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


import java.util.List;


public interface productDao {
    @Select("select * from product")
    public List<Product> findAll() throws Exception;
    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
    @Select("select * from product where id=#{id}")
    public Product findById( int id)throws Exception;
}
