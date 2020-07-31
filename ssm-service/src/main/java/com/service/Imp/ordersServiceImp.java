package com.service.Imp;

import com.dao.ordersDao;
import com.domain.Orders;

import com.github.pagehelper.PageHelper;
import com.service.ordersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: wudaren
 * @create: 2020-07-27 17:26
 **/
@Service
public class ordersServiceImp implements ordersService {
    @Autowired
    private ordersDao dao;
    @Override
    public List<Orders> findAll(int page, int size) throws Exception{
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public Orders findById(String id) {
        return dao.findById(id);
    }
}
