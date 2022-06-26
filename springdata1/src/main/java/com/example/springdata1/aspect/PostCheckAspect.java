package com.example.springdata1.aspect;

import com.example.springdata1.error.AopIsAwesomeHeaderException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class PostCheckAspect {
    private final HttpServletRequest httpServletRequest;

    public PostCheckAspect(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Pointcut("@annotation(com.example.springdata1.annotation.PostCheck)")
    public void postCheckAspect() {
    }

    @Around("postCheckAspect()")
    public Object logging(ProceedingJoinPoint jp) throws Throwable {
        if(httpServletRequest.getMethod().equals("POST") && httpServletRequest.getHeader("AOP-IS-AWESOME")==null){
            throw new AopIsAwesomeHeaderException("Header missing");
        }
        return jp.proceed();
    }
}
