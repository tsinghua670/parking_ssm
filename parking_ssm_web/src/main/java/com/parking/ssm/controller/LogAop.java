package com.parking.ssm.controller;

import com.parking.ssm.domain.SysLog;
import com.parking.ssm.service.ISysLogService;
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

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime;//开始时间
    private Class clazz;//访问的类
    private Method method;//访问的方法

    //前置通知 主要是获取开始时间，执行的类是哪个，执行的是哪个方法
    @Before("execution(* com.parking.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException{
        visitTime = new Date();//当前时间就是开始的时间
        clazz = jp.getTarget().getClass();//获取具体访问的类
        String methodName = jp.getSignature().getName();//获取访问方法的名称
        Object[] args = jp.getArgs(); //获取访问方法的参数

        //获取具体执行的方法的method对象
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName); //只能获取无参数的方法
        }else {
            Class[] classArgs = new Class[args.length];
            for (int i=0;i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
           method = clazz.getMethod(methodName,classArgs);// 获取有参数方法
        }
    }

    //后置通知   主要获取日志中其它信息，时长、ip、url...
    @After("execution(* com.parking.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        long time = new Date().getTime() - visitTime.getTime(); // 获取访问时间

        String url = "";
        //获取url
        if (clazz != null && method != null && clazz != LogAop.class) {
            //1.获取类上的@RequestMapping(xxx)
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValue = classAnnotation.value();
                //2.获取方法上的@RequestMapping(xxx)
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];

                    //获取ip
                    String ip = request.getRemoteAddr();

                    //获取当前操作者
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文获取当前登录的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username =  user.getUsername();

                    SysLog sysLog = new SysLog();
                    sysLog.setVisitTime(visitTime);
                    sysLog.setUsername(username);
                    sysLog.setIp(ip);
                    sysLog.setUrl(url);
                    sysLog.setExecutionTime(time);
                    sysLog.setMethod("[类名]"+ clazz.getName() +"[方法名]" + method.getName());

                    //将日志存进数据库
                    sysLogService.save(sysLog);
                }
            }
        }

    }

}
