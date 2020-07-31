package com.service;

import com.domain.Orders;


import java.util.List;

public interface ordersService {
    public List<Orders> findAll(int size, int page) throws Exception;

    Orders findById(String id);
}
