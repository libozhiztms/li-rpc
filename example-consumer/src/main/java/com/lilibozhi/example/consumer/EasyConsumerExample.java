package com.lilibozhi.example.consumer;

import com.lilibozhi.example.common.model.User;
import com.lilibozhi.example.common.service.UserService;
import com.lilibozhi.lirpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {
    public static void main(String[] args) {
        //todo 需要获取UserService 的实现对象
        //UserService userService=null;
        //静态代理
        //UserService userService=new UserServiceProxy();
        //动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("libozhi");

        //调用
        User newUser = userService.getUser(user);
        if(newUser!=null){
            System.out.println(newUser.getName());
        }else{
            System.out.println("user == null");
        }
    }
}
