package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    JdbcTemplate jt=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User findUserByNameAndPassword(String username, String password) {
        User loginUser = null;
        try {
            String sql="select * from user where username=? and password=?";
            loginUser = jt.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),username,password);
        } catch (DataAccessException e) {
        }
        return loginUser;
    }

    @Override
    public User findUserByName(String username) {
        User loginUser = null;
        try {
            String sql="select * from user where username=?";
            loginUser = jt.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),username);
        } catch (DataAccessException e) {
        }
        return loginUser;
    }
}
