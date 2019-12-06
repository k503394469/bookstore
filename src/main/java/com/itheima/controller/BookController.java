package com.itheima.controller;

import com.itheima.domain.Books;
import com.itheima.domain.PageBean;
import com.itheima.service.BookService;
import com.itheima.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/*")
public class BookController extends BaseController {
    private BookService service=new BookServiceImpl();
    public void showBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String category = request.getParameter("category");
        String bookName = request.getParameter("bookName");
        String currentPage_str = request.getParameter("currentPage");

        if (category==null||"".equals(category)){
            category="文学";
        }
        int currentPage=0;
        if (currentPage_str==null||"".equals(currentPage_str)||"null".equals(currentPage_str)){
            currentPage=1;
        }
        int pageSize=2;
        PageBean<Books> pageBean = service.findQuery(category, bookName, currentPage, pageSize);
        System.out.println(pageBean);
        request.setAttribute("category",category);
        request.setAttribute("pb",pageBean);
        request.getRequestDispatcher("/product_list.jsp").forward(request,response);

    }
}
