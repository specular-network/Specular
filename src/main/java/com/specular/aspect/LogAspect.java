package com.specular.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jzx
 * @date 2019/03/01 11:17
 * @Description:
 */
@Aspect
@Component
@Slf4j

public class LogAspect {
    // default implementation ignored
    @Pointcut("execution(public * com.specular..controller.*.*(..))")
    public void log(){
    
    }
    
    @Before("log()")
    public void doBefore(JoinPoint joinpoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //过滤info请求
        if(!request.getRequestURI().endsWith("info/")){
            // Aspect
            log.info("url={} \r\n method={} \r\n id={} \r\n class_method={} \r\n args={}",
                    request.getRequestURL(),request.getMethod(),request.getRemoteAddr()
                    ,joinpoint.getSignature().getDeclaringTypeName() + "," + joinpoint.getSignature().getName(),
                    joinpoint.getArgs());
        }
    }
}
