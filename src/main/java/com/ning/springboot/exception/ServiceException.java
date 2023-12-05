package com.ning.springboot.exception;

import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * 自定义异常
 */
@Getter
public class ServiceException extends RuntimeException {
    private Integer code;

    public ServiceException(Integer code) {
        this.code = code;
    }
    public ServiceException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
    @Override
    public String toString() {
       if (StringUtils.isEmpty(super.getMessage())) {
           return code.toString();
       }
       return super.getMessage();
    }

}
