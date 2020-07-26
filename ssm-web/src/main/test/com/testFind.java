package com;

import com.dao.productDao;
import com.domain.Product;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: wudaren
 * @create: 2020-07-26 11:50
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applactionContext.xml" })
public class testFind {
    @Autowired
    private productDao dao;
    public void testad(){
        List<Product> all = dao.findAll();
        System.out.println(all);
    }
}
