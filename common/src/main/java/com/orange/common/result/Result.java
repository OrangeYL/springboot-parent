package com.orange.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/22 14:03
 * @description: 统一结果封装
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    //状态码
    private Integer code;

    //返回信息
    private String message;

    //返回数据
    private T data;

    /**成功且带数据**/
    public static <T> Result<T> success(T data){
        Result<T> tResult = new Result<>();
        tResult.setCode(ResultEnum.SUCCESS.getCode());
        tResult.setMessage(ResultEnum.SUCCESS.getMessage());
        tResult.setData(data);
        return tResult;
    }
    /**成功但不带数据**/
    public static <T> Result<T> success(){
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        return result;
    }
    /**成功但不带数据**/
    public static <T> Result<T> success(String msg){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage(msg);
        return result;
    }
    /**失败,枚举错误**/
    public static <T> Result<T> error(ResultEnum resultEnum){
        Result<T> result = new Result<>();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }
    /**失败,自定义返回信息**/
    public static <T> Result<T> error(String msg) {
        return new Result<>(ResultEnum.UNKNOWN_ERROR.getCode(),msg);
    }
    /**失败,自定义状态码，返回信息**/
    public static <T> Result<T> error(Integer code,String msg){
        return new Result<>(code,msg);
    }
    public Result(int code,String message){
        this.code = code;
        this.message = message;
    }

}
