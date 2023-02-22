package com.orange.common.exception;

import lombok.Data;

import java.util.Map;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/22 14:26
 * @description: 自定义异常
 */
@Data
public class BizException extends RuntimeException{

    private Integer code;

    public BizException(){

    }
    public BizException(String message){
        super(message);
    }

    public BizException(int code,String message){
        super(message);
        this.code = code;
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
