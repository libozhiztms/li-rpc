package com.lilibozhi.example.provider;

import com.lilibozhi.example.common.service.UserService;
import com.lilibozhi.lirpc.registry.LocalRegistry;
import com.lilibozhi.lirpc.server.HttpServer;
import com.lilibozhi.lirpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {
    public static void main(String[] args) {
        //注册服务
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);
        //提供 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
