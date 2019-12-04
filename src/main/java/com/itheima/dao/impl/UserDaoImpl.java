package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    JdbcTemplate jt=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User findUserByNameAndPassword(String username, String password) {
        String sql="select * from user where username=? and password=?";
        User loginUser = jt.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),username,password);
        return loginUser;
    }
}
