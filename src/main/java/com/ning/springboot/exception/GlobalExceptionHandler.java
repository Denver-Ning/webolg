package com.ning.springboot.exception;

import com.ning.springboot.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常处理
     * @param
     * @return Result
     */

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result handle(ServiceException e){
        return Result.error(e.getCode(),e.getMessage());
    }

    /**
     * 空指针异常处理
     */
    @ExceptionHandler(NullPointerException.class)
    public Result handle(NullPointerException e){
        return Result.error(500,e.getMessage());
    }
}
