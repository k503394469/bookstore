package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {
    User findUserByNameAndPassword(String username,String password);
}
