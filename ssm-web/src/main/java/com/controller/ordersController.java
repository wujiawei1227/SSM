package com.controller;

import com.domain.Orders;

import com.github.pagehelper.PageInfo;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.service.ordersService;
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
 * @create: 2020-07-27 16:11
 **/
@Controller
@RequestMapping("orders")
public class ordersController {
    @Autowired
    private ordersService service;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(required = true) Integer page,
                                @RequestParam(required = true) Integer size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Orders> all = service.findAll(page,size);

        PageInfo pageInfo = new PageInfo(all);
        mv.setViewName("orders-page-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        Orders byId = service.findById(id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("orders-show");
        mv.addObject("orders",byId);
        return mv;

    }

}
