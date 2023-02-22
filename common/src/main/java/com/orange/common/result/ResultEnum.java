package com.orange.common.result;

import org.omg.CORBA.UNKNOWN;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/22 14:17
 * @description: 枚举常见错误
 */
public enum ResultEnum {

    SUCCESS(200,"操作成功"),
    UNKNOWN_ERROR(-1,"未知错误");

    private Integer code;

    private String message;

    ResultEnum(int code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
