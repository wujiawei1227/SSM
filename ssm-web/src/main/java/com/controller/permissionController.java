package com.controller;

import com.domain.Permission;
import com.domain.Product;
import com.domain.UserInfo;
import com.github.pagehelper.PageInfo;
import com.service.PermissionService;
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
 * @create: 2020-07-31 11:08
 **/
@Controller
@RequestMapping("permission")
public class permissionController  {
    @Autowired
    private PermissionService service;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(required = true,defaultValue = "1") Integer page,
                                @RequestParam(required = true,defaultValue = "5") Integer size) throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Permission> all = service.findAll(size,page);
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("permission-list");
        return mv;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(required = true) int id) throws Exception{
        ModelAndView mv=new ModelAndView();
        Permission byId = service.findById(id);
        mv.addObject("permission",byId);
        mv.setViewName("permission-show");
        return mv;
    }
    @RequestMapping("/save.do")
    public String addUser(Permission permission){
        service.save(permission);
        return "redirect:findAll.do";
    }
}
