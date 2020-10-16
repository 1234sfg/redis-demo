package com.leaf.utils;

import lombok.Data;

@Data
public class Result {
    private Integer code;//返回错误码
    private String message;//返回结果信息
    private Object data;//返回数据

    public Result(Object data) {
        this.data = data;
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.message = message;
        this.code = code;
    }


    public Result(Integer code, String message, Object data) {
        this.code=code;
        this.message=message;
        this.data=data;
    }
}
