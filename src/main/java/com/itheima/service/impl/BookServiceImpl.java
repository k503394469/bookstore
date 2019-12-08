package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.dao.impl.BookDaoImpl;
import com.itheima.domain.Books;
import com.itheima.domain.PageBean;
import com.itheima.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao dao=new BookDaoImpl();
    @Override
    public PageBean<Books> findQuery(String category, String bookName, int currentPage, int pageSize) {
        PageBean<Books> page=new PageBean<>();
        if (currentPage<=0){
            currentPage=1;
        }
        if (category==null||"".equals(category)||"null".equals(category)){
            category="文学";
        }
        page.setCurrentPage(currentPage);
        page.setPageSize(pageSize);
        Integer count = dao.findCountByCategoryAndBookName(category, bookName);
        page.setTotalCount(count);
        int totalPage=(count%pageSize==0)?count/pageSize:count/pageSize+1;
        page.setTotalPage(totalPage);
        int start=(currentPage-1)*pageSize;
        List<Books> bookList = dao.findBookListByPage(category, bookName, start, pageSize);
        page.setObjectList(bookList);
        return page;
    }

    @Override
    public Books findBookById(int id) {
        Books book=dao.findBookById(id);
        return book;
    }

    @Override
    public void editBook(Books book) {
        dao.update(book);
    }

    @Override
    public void deleteByIdAndName(int id, String name) {
        dao.deleteByIdAndName(id,name);
    }
}
