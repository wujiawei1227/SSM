package com.service.Imp;


import com.dao.productDao;
import com.domain.Product;
import com.github.pagehelper.PageHelper;
import com.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: wudaren
 * @create: 2020-07-25 19:03
 **/

@Transactional
@Service
public class productServiceImp  implements productService {
@Autowired
    private productDao dao;
    @Override
    public List<Product> findAll(int size, int page) throws Exception {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public void save(Product product) {
        dao.save(product);
    }


}
