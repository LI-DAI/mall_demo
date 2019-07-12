/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.aspect;

import com.alibaba.fastjson.JSONObject;
import com.mall.admin.utils.SecurityUtils;
import com.mall.common.entity.AccessLog;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lidai
 * @date 2019/7/11 15:00
 * @since
 */
@Aspect
@Component
@Slf4j
public class AccessLogAspect {

    @Pointcut("execution( * com.mall.admin.controller.*.*(..))")
    public void log() {
    }

    @Around(value = "log()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalDateTime start = LocalDateTime.now();
        long currentMills = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        AccessLog accessLog = new AccessLog();
        //执行
        Object result = joinPoint.proceed();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String description = null;
        if (method.isAnnotationPresent(ApiOperation.class)) {
            ApiOperation operation = method.getAnnotation(ApiOperation.class);
            description = operation.value();
        }
        accessLog.setDescription(description);
        accessLog.setMethod(method.getName());
        accessLog.setParameter(request.getParameterMap());
        accessLog.setUrl(request.getRequestURI());
        accessLog.setResult(result);
        accessLog.setDuration(System.currentTimeMillis() - currentMills);
        accessLog.setUsername(SecurityUtils.getCurrentUser().getUsername());
        accessLog.setIp(request.getRemoteAddr());
        accessLog.setStartTime(start);
        log.info("operation start time : {}", start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        // TODO: 2019/7/11 Json里得LocalDateTime总是显示为Long类型数字
        log.info(JSONObject.toJSONString(accessLog));
        return result;
    }

}

