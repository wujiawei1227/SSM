package com.controller;

import com.domain.SysLog;
import com.domain.UserInfo;
import com.github.pagehelper.PageInfo;
import com.service.SysLogService;
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
 * @create: 2020-08-01 16:56
 **/
@RequestMapping("/sysLog")
@Controller
public class SysLogController {

    @Autowired
    private SysLogService service;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(required = true,defaultValue = "1") Integer page,
                                @RequestParam(required = true,defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> all=null;
        try {
            all = service.findAll(page,size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }
}
