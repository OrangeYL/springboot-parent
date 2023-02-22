package com.orange.demo.async.task;

import com.orange.demo.user.entity.User;
import com.orange.demo.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/22 16:50
 * @description: 测试异步任务
 */
@Component
@Slf4j
public class AsyncTask {

    @Autowired
   private IUserService userService;

    @Async
    public Future<List<User>> getUserListAsy(){
        log.info("================开始执行查询任务===============");
        List<User> users = userService.listAllUsers();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("================结束查询任务===================");
        return new AsyncResult<>(users);
    }

    @Async
    public Future<List<User>> getListAsy(){
        log.info("================开始执行查询任务===============");
        List<User> users = userService.listAllUsers();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("================结束查询任务===================");
        return new AsyncResult<>(users);
    }

    public List<User> getUserListNor(){
        log.info("================开始执行查询任务===============");
        List<User> users = userService.listAllUsers();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("================结束查询任务===================");
        return users;
    }
    public List<User> getListNor(){
        log.info("================开始执行查询任务===============");
        List<User> users = userService.listAllUsers();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("================结束查询任务===================");
        return users;
    }

}
