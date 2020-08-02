package com.controller;

import com.domain.Permission;
import com.domain.Role;
import com.domain.UserInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.service.PermissionService;
import com.service.RoleService;
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
 * @create: 2020-07-31 10:14
 **/
@RequestMapping("role")
@Controller
public class roleController {
    @Autowired
    private RoleService service;
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(required = true,defaultValue = "1") int page,
                                @RequestParam(required = true,defaultValue = "5") int size){
        ModelAndView mv=new ModelAndView();
        List<Role>all=null;
        try {
            all = service.findAll(page,size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo pageInfo=new PageInfo(all);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Role role){
        service.save(role);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndALlPermission(@RequestParam(name = "id",required = true) int roleId){
        ModelAndView mv=new ModelAndView();
        Role byId = service.findById(roleId);
        mv.addObject("role",byId);
        List<Permission> otherPermission = permissionService.findOtherPermission(roleId);
        mv.addObject("permissionList",otherPermission);
        mv.setViewName("role-permission-add");
        return mv;
    }
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId")int roleId,
                                      @RequestParam(name = "ids")int[] permissionIds){
        service.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(required = true) int id) throws Exception{
        ModelAndView mv=new ModelAndView();
        Role byId = service.findById(id);
        mv.addObject("role",byId);
        mv.setViewName("role-show");
        return mv;
    }
}
