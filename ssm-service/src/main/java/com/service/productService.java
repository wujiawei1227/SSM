package com.service;

import com.domain.Product;

import java.util.List;

public interface productService {
    public List<Product> findAll(int size, int page) throws Exception;

    void save(Product product);
}
