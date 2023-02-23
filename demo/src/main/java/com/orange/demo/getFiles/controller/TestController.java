package com.orange.demo.getFiles.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/23 16:16
 * @description:
 */
@RestController
public class TestController {

    @GetMapping("/getFile")
    public List<File> getAllFile(String dirFilePath){
        if(StringUtils.isBlank(dirFilePath)){
            return null;
        }
        return getAllFile(new File(dirFilePath));
    }

    public List<File> getAllFile(File dirFile){
        // 如果文件夹不存在或着不是文件夹，则返回 null
        if(Objects.isNull(dirFile) || !dirFile.exists() || dirFile.isFile()){
            return null;
        }
        File[] childrenFiles =  dirFile.listFiles();
        if(Objects.isNull(childrenFiles) || childrenFiles.length == 0){
            return null;
        }
        List<File> files = new ArrayList<>();
        for(File childFile : childrenFiles) {
            // 如果时文件，直接添加到结果集合
            if(childFile.isFile()) {
                files.add(childFile);
            }else {
                // 如果是文件夹。则先将其添加到结果集合，再将其内部文件添加进结果集合。
                files.add(childFile);
                List<File> cFiles =  getAllFile(childFile);
                if(Objects.isNull(cFiles) || cFiles.isEmpty()) continue;
                files.addAll(cFiles);
            }
        }
        return files;
    }

}
