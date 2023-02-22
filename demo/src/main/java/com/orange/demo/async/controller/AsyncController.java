package com.orange.demo.async.controller;

import com.orange.demo.async.task.AsyncTask;
import com.orange.demo.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/22 16:51
 * @description: 测试异步任务
 */
@RestController
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncTask asyncTask;

    /**
     * @description: 测试异步查询任务，耗时3秒多
     * @author: Li ZhiCheng
     * @date: 2022/9/6 11:19
     * @param: [id]
     * @return: com.orange.springboot.utils.Result<com.orange.springboot.entity.User>
     **/
    @GetMapping("/async")
    public void testAsync(){
        long start = System.currentTimeMillis();
        Future<List<User>> result = asyncTask.getUserListAsy();
        Future<List<User>> resultList = asyncTask.getListAsy();
        try {
            List<User> users = result.get();
            List<User> userList = resultList.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("耗时："+ (System.currentTimeMillis()-start)+"毫秒");
    }
    /**
     * @description: 没有异步任务，串行执行，耗时4秒多
     * @author: Li ZhiCheng
     * @date: 2023/2/22 17:00
     * @param: []
     * @return: void
     **/
    @GetMapping("/nor")
    public void testNor(){
        long start = System.currentTimeMillis();
        List<User> userListNor = asyncTask.getUserListNor();
        List<User> listNor = asyncTask.getListNor();
        log.info("耗时："+ (System.currentTimeMillis()-start)+"毫秒");
    }
}
