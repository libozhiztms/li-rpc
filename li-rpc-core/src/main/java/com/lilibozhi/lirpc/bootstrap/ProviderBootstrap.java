package com.lilibozhi.lirpc.bootstrap;


import com.lilibozhi.lirpc.RpcApplication;
import com.lilibozhi.lirpc.config.RegistryConfig;
import com.lilibozhi.lirpc.config.RpcConfig;
import com.lilibozhi.lirpc.model.ServiceMetaInfo;
import com.lilibozhi.lirpc.model.ServiceRegisterInfo;
import com.lilibozhi.lirpc.registry.LocalRegistry;
import com.lilibozhi.lirpc.registry.Registry;
import com.lilibozhi.lirpc.registry.RegistryFactory;
import com.lilibozhi.lirpc.server.tcp.VertxTcpClient;
import com.lilibozhi.lirpc.server.tcp.VertxTcpServer;

import java.util.List;

/**
 * 服务提供者初始化
 */
public class ProviderBootstrap {

    public static void init(List<ServiceRegisterInfo<?>> serviceRegisterInfoList){
        //RPC框架初始化
        RpcApplication.init();

        //全局配置
        final RpcConfig rpcConfig=RpcApplication.getRpcConfig();

        //注册服务
        for (ServiceRegisterInfo<?> serviceRegisterInfo:serviceRegisterInfoList){
            String serviceName = serviceRegisterInfo.getServiceName();
            //本地注册
            LocalRegistry.register(serviceName,serviceRegisterInfo.getImplClass());

            //注册服务到注册中心
            RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
            Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
            ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName(serviceName);
            serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
            serviceMetaInfo.setServicePort(serviceMetaInfo.getServicePort());
            try {
                registry.register(serviceMetaInfo);
            } catch (Exception e) {
                throw new RuntimeException(serviceName+" 服务注册失败" ,e);
            }
        }

        //启动服务器
        VertxTcpServer vertxTcpServer=new VertxTcpServer();
        vertxTcpServer.doStart(rpcConfig.getServerPort());

    }
}
