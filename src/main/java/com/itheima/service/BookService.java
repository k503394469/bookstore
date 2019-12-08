package com.itheima.service;

import com.itheima.domain.Books;
import com.itheima.domain.PageBean;

public interface BookService {
    PageBean<Books> findQuery(String category,String bookName,int currentPage,int pageSize);

    Books findBookById(int id);

    void editBook(Books book);

    void deleteByIdAndName(int id, String name);
}
