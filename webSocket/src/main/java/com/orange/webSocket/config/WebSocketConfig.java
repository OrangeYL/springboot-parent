package com.orange.webSocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/27 16:13
 * @description: webSocket配置类
 */
@Configuration
public class WebSocketConfig {

    /**
     * ServerEndpointExporter作用:这个Bean会自动注册使用@ServerEndpoint注解声明的websocket endpoint
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
