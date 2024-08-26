package com.lilibozhi.example.provider;

import com.lilibozhi.example.common.service.UserService;
import com.lilibozhi.lirpc.RpcApplication;
import com.lilibozhi.lirpc.bootstrap.ProviderBootstrap;
import com.lilibozhi.lirpc.config.RegistryConfig;
import com.lilibozhi.lirpc.config.RpcConfig;
import com.lilibozhi.lirpc.model.ServiceMetaInfo;
import com.lilibozhi.lirpc.model.ServiceRegisterInfo;
import com.lilibozhi.lirpc.registry.LocalRegistry;
import com.lilibozhi.lirpc.registry.Registry;
import com.lilibozhi.lirpc.registry.RegistryFactory;
import com.lilibozhi.lirpc.server.HttpServer;
import com.lilibozhi.lirpc.server.VertxHttpServer;
import com.lilibozhi.lirpc.server.tcp.VertxTcpServer;

import java.util.ArrayList;
import java.util.List;

public class ProviderExample {
    public static void main(String[] args) {

        //要注册的服务
        List<ServiceRegisterInfo<?>> serviceRegisterInfoList=new ArrayList<>();
        ServiceRegisterInfo serviceRegisterInfo = new ServiceRegisterInfo(UserService.class.getName(), UserServiceImpl.class);
        serviceRegisterInfoList.add(serviceRegisterInfo);

        //服务提供者初始化
        ProviderBootstrap.init(serviceRegisterInfoList);

//        //RPC 框架初始化
//        RpcApplication.init();
//
//        //注册服务
//        //LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
//        String serviceName = UserService.class.getName();
//        LocalRegistry.register(serviceName, UserServiceImpl.class);
//
//        //注册服务到注册中心
//        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
//        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
//        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
//        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
//        serviceMetaInfo.setServiceName(serviceName);
//        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
//        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
//        try {
//            registry.register(serviceMetaInfo);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        //启动 TCP 服务
//        VertxTcpServer vertxTcpServer = new VertxTcpServer();
//        vertxTcpServer.doStart(8082);
//        //vertxHttpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
