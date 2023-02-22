package com.orange.demo.readTxt.controller;

import com.orange.demo.readTxt.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/22 10:05
 * @description: 该类用于测试读取Txt文件
 */
@RestController
@RequestMapping("/txt")
public class ReadTxtController {

    @RequestMapping("/get")
    public List<Student> getData(@RequestParam(value = "path") String path){
        List<Student> students = new ArrayList<>();
        try {
            File file = new File(path);
            InputStream inputStream = new FileInputStream(file);
            students = readTxt(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("路径不存在！");
        }
        return students;
    }
    public List<Student> readTxt(InputStream is){
        List<Student> students = new ArrayList<>();
        try {
            InputStreamReader reader = new InputStreamReader(is, "GBK");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while((line = bufferedReader.readLine()) != null){
                Student student = new Student();
                String[] data = line.split(",");
                String name = data[0];
                int grate = Integer.parseInt(data[1]);
                Date date = format.parse(data[2]);
                student.setName(name);
                student.setGrade(grate);
                student.setRecodeTime(date);
                students.add(student);
            }
            bufferedReader.close();
            reader.close();
            is.close();
        } catch (Exception e) {
            System.out.println("文件读取错误！");
        }
        return students;
    }

}
