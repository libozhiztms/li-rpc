package com.lilibozhi.example.provider;

import com.lilibozhi.example.common.model.User;
import com.lilibozhi.example.common.service.UserService;

/**
 * 用户服务实现类
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        System.out.println("用户名："+user.getName());
        return user;
    }
}
