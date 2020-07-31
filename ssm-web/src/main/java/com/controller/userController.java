package com.controller;

import com.domain.UserInfo;
import com.github.pagehelper.PageInfo;
import com.service.UserService;
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
 * @create: 2020-07-30 17:52
 **/
@Controller
@RequestMapping("user")
public class userController {
    @Autowired
    private UserService service;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(required = true,defaultValue = "1") Integer page,
                                @RequestParam(required = true,defaultValue = "4") Integer size){

        ModelAndView mv=new ModelAndView();
        List<UserInfo> all=null;
        try {
           all = service.findAll(page,size);
            for (UserInfo userInfo : all) {
                System.out.println(userInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("userList",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String addUser(UserInfo userInfo){
        service.save(userInfo);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(required = true) int id) throws Exception{
        ModelAndView mv=new ModelAndView();
        UserInfo byId = service.findById(id);
        mv.addObject("user",byId);
        mv.setViewName("user-show");
        return mv;
    }
}
