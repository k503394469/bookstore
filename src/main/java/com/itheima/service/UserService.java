package com.itheima.service;

import com.itheima.domain.User;

public interface UserService {
    User login(String username,String password);

    User checkName(String username);
}
