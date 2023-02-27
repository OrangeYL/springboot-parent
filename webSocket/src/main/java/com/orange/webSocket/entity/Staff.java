package com.orange.webSocket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/27 16:19
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer staffId;

    private String email;

    private String username;

    private String password;
}
