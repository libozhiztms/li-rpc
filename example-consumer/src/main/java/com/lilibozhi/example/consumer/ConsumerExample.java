package com.lilibozhi.example.consumer;

import com.lilibozhi.example.common.model.User;
import com.lilibozhi.example.common.service.UserService;
import com.lilibozhi.lirpc.bootstrap.ConsumerBootstrap;
import com.lilibozhi.lirpc.config.RpcConfig;
import com.lilibozhi.lirpc.proxy.ServiceProxyFactory;
import com.lilibozhi.lirpc.utils.ConfigUtils;

public class ConsumerExample {
    public static void main(String[] args) {

        ConsumerBootstrap.init();
//        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
//        System.out.println(rpc);
        //获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("lilibozhi");
        //调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
        User user2 = new User();
        user2.setName("lilibozhi222");
        //调用
        User newUser2 = userService.getUser(user2);
        if (newUser != null) {
            System.out.println(newUser2.getName());
        } else {
            System.out.println("user2 == null");
        }
//        long number = userService.getNumber();
//        System.out.println(number);
    }
}
