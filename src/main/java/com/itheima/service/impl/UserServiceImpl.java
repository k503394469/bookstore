package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        User loginUser=dao.findUserByNameAndPassword(username, password);
        return loginUser;
    }

    @Override
    public User checkName(String username) {
        User check=dao.findUserByName(username);
        return check;
    }
}
