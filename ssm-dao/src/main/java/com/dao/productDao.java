package com.dao;

import com.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;


public interface productDao {
    @Select("select * from product")
    public List<Product> findAll();
}
