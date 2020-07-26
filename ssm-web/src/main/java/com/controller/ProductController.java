package com.controller;

import com.domain.Product;
import com.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: wudaren
 * @create: 2020-07-25 20:59
 **/
@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
  private productService service;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        System.out.println("con执行了"+service);
        ModelAndView mv=new ModelAndView();
        List<Product> all = service.findAll();
        System.out.println("contr"+all);
        mv.addObject("productList",all);
        mv.setViewName("product-list");
        return mv;
    }
}
