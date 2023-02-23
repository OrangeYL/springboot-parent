package com.orange.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/21 11:24
 * @description: 该模块用于日常练习和学习较小的知识所用
 */
@SpringBootApplication(scanBasePackages = {"com.orange.common","com.orange.demo"})
@EnableAsync
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }
}
