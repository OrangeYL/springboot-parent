package com.orange.webSocket.service;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/27 16:29
 * @description:
 */
public interface LoginService {

    public String getPasswordByName(String name);

    public Integer getIdByName(String name);

    public String getNameById(int id);
}
