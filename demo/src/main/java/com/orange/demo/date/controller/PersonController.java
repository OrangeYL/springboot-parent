package com.orange.demo.date.controller;

import com.orange.demo.date.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/21 11:33
 * @description:
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/test")
    public Person test(Person person){
        Date birthDate = person.getBirthDate();
        Person p = new Person();
        p.setBirthDate(birthDate);

        System.out.println("出生日期是："+birthDate);
        return p;
    }
}
