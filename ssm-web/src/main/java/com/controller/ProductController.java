package com.controller;

import com.domain.Product;
import com.github.pagehelper.PageInfo;
import com.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView findAll(@RequestParam(required = true,defaultValue = "1") Integer page,
                                @RequestParam(required = true,defaultValue = "4") Integer size) throws Exception{
        System.out.println("con执行了"+service);
        ModelAndView mv=new ModelAndView();
        List<Product> all = service.findAll(size,page);
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("productList",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String addProduct(Product product){
        service.save(product);
        return "redirect:findAll.do";


    }

}
