package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.Books;
import com.itheima.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private JdbcTemplate jt=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Integer findCountByCategoryAndBookName(String category,String bookName) {
        String sql="select count(*) from books where 1=1 ";
        StringBuffer sb=new StringBuffer(sql);
        List<Object> paras=new ArrayList<>();
        if (category!=null&&!"".equals(category)&&!"null".equals(category)){
            sb.append(" and category=? ");
            paras.add(category);
        }
        if (bookName!=null&&!"".equals(bookName)&&!"null".equals(bookName)){
            sb.append(" and name like %"+bookName+"%");
            paras.add(bookName);
        }
        sql=sb.toString();
        Integer count = jt.queryForObject(sql, Integer.class, paras.toArray());
        return count;
    }

    @Override
    public List<Books> findBookListByPage(String category, String bookName, int start, int pageSize) {
        String sql = "select * from books where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        List paras = new ArrayList();
        if (category!=null&&!"".equals(category)&&!"null".equals(category)){
            sb.append(" and category=? ");
            paras.add(category);
        }
        if (bookName!=null&&!"".equals(bookName)&&!"null".equals(bookName)){
            sb.append(" and name like %"+bookName+"% ");
            paras.add(bookName);
        }
        sb.append(" limit ? , ?");
        paras.add(start);
        paras.add(pageSize);
        sql = sb.toString();
        List<Books> booksList = jt.query(sql, new BeanPropertyRowMapper<>(Books.class), paras.toArray());
        System.out.println(booksList);
        return booksList;
    }

}
