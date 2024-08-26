package com.lilibozhi.examplespringbootconsumer;

import com.lilibozhi.example.common.model.User;
import com.lilibozhi.example.common.service.UserService;
import com.lilibozhi.lirpc.springboot.starter.annotation.RpcReference;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl {

    @RpcReference
    private UserService userService;

    public void test(){
        User user=new User();
        user.setName("libozhizzzzzz");
        User resultUser = userService.getUser(user);
        System.out.println(resultUser.getName());
    }
}
