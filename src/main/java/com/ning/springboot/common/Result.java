package com.ning.springboot.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一接口返回包装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public static Result success() {
        return new Result(Constants.CODE_200, "success", null);
    }
    public static Result success(Object data){
        return new Result(Constants.CODE_200, "success", data);
    }
    public static Result success(Boolean flag){
        return new Result(Constants.CODE_200, "success", flag);
    }
    public static Result error() {
        return new Result(Constants.CODE_500, "系统错误", null);
    }
    public static Result error( Object data,String msg) {
        return new Result(Constants.CODE_500, msg, data);
    }
}
