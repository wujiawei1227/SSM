package com.controller;

import com.domain.SysLog;
import com.domain.UserInfo;
import com.service.SysLogService;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @program: SSM
 * @description:
 * @author: wudaren
 * @create: 2020-08-01 16:32
 **/
@Component
@Aspect
public class LogAop {
    @Autowired
   private HttpServletRequest request;
    @Autowired
    private SysLogService service;

    private Date startTime;//访问时间
    private Class excutionClass;//访问的类
    private Method excutionMethod;//访问的方法

    //前置通知获取访问时间，访问的类，访问的方法
    @Before("execution(* com.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException,SecurityException{
        startTime=new Date();//访问时间
        excutionClass = jp.getTarget().getClass();//获取访问的类
        String name = jp.getSignature().getName();//获取访问的方法名称
        Object[] args = jp.getArgs();//获取方法的参数名称
        if (args==null||args.length==0){
            //无参数
            //获取无参数的方法
            excutionMethod = excutionClass.getMethod(name);
        }else {
            //有参数，将args中的参数遍历，获取对应的class。转入一个class数组
            Class[] classes = new Class[args.length];
            for (int i = 0; i <args.length; i++) {
                classes[i]=args[i].getClass();
            }
            //获取有参数的方法
            excutionMethod = excutionClass.getMethod(name, classes);

        }
    }
    @After("execution(* com.controller.*.*(..))")
    public void doAfter(JoinPoint jp)throws Exception{
        //获取类上的requestmapping对象
        if (excutionClass!=SysLogController.class){
           RequestMapping classAnnotation=(RequestMapping) excutionClass.getAnnotation(RequestMapping.class);
            if (classAnnotation!=null){
                //获取方法上的requestmapping对象
                RequestMapping methodAnnotation = excutionMethod.getAnnotation(RequestMapping.class);
                if (methodAnnotation!=null){
                    String url="";
                    url=classAnnotation.value()[0]+methodAnnotation.value()[0];
                    SysLog sysLog=new SysLog();
                    //获取访问时常
                    long executionTime = new Date().getTime() - startTime.getTime();
                    sysLog.setExecutionTime(executionTime);
                    sysLog.setUrl(url);
                    //获取Ip
                    String remoteAddr = request.getRemoteAddr();
                    sysLog.setIp(remoteAddr);
                    //获取当前用户名
                    SecurityContext context = SecurityContextHolder.getContext();
                    String username = ((User) (context.getAuthentication().getPrincipal())).getUsername();
                    sysLog.setUsername(username);
                    sysLog.setMethod("[类名]" + excutionClass.getName() + "[方法名]" +
                            excutionMethod.getName());
                    sysLog.setVisitTime(startTime);
                    // 调用Service，调用dao将sysLog insert数据库
                    service.save(sysLog);

                }
            }
        }
    }

}
