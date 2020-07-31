package com.dao;

import com.domain.traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: wudaren
 * @create: 2020-07-28 11:58
 **/

public interface travellerDao {
    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{id})")
    public List<traveller> findByOrdersId(int id);
}
