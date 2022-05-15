package com.allen.sb_01_mybatisplus.controller.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    /**
     * 拦截所有的异常，可做如下操作
     *      1、记录日志
     *      2、通知运维
     *      3、通知开发
     *      @ExceptionHandler(Exception.class) 参数可以添加特定的异常、如自定义异常
     */
    @ExceptionHandler(Exception.class)
    public ResultVO doException(Exception e) {
        e.printStackTrace();
        return new ResultVO("服务器故障，请稍后再试");
    }
}
