package com.itheima.dao;

import com.itheima.domain.Books;

import java.util.List;

public interface BookDao {
    Integer findCountByCategoryAndBookName(String category,String bookName);
    List<Books> findBookListByPage(String category,String bookName,int start,int pageSize);
}
