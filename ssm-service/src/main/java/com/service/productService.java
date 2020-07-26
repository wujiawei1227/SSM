package com.service;

import com.domain.Product;

import java.util.List;

public interface productService {
    public List<Product> findAll() throws Exception;
}
