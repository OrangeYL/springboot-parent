package com.orange.demo.date.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/21 11:29
 * @description: 实体类，该模块用于测试日期注解 @JsonFormat @DateTimeFormat
 */
/**
 *  JsonFormat注解: 这是一个时间格式化注解，一般用在实体类的日期属性上，当我们存储在mysql中的数据是date类型时，读取之后封装成实体类时，
 *                 时间就会变成英文格式，而不是yyyy-MM-dd HH:mm:ss这样的中文时间，这个时候就需要用到JsonFormat注解来格式化我们的时间。
 *                 需要注意的是，只有在我们声明返回类型是json格式的时候，比如使用@ResponseBody注解返回json数据，这个注解才会起作用，如果
 *                 是直接使用System.out.println()输出的话，仍然是类似“Fri Dec 01 21:05:20 CST 2017”这样的时间样式。
 *
 *  DateTimeFormat注解：这个注解的作用是格式化入参，如果不使用该注解，在传入参数时，字段的类型时String,而我们需要Date类型的参数，因此就会报异常，
 *                     使用该注解可以解决该问题，需要注意的是，入参的格式必须符合pattern里面的格式。
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    //日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthDate;
}
