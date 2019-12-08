package com.itheima.controller;

import com.itheima.domain.Books;
import com.itheima.domain.PageBean;
import com.itheima.domain.ResultInfo;
import com.itheima.service.BookService;
import com.itheima.service.impl.BookServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/book/*")
public class BookController extends BaseController {
    private BookService service = new BookServiceImpl();

    public void showBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String category = request.getParameter("category");
        String bookName = request.getParameter("bookName");
        String currentPage_str = request.getParameter("currentPage");

        if (category == null || "".equals(category)) {
            category = "文学";
        }
        int currentPage = 0;
        if (currentPage_str == null || "".equals(currentPage_str) || "null".equals(currentPage_str)) {
            currentPage = 1;
        }
        int pageSize = 2;
        PageBean<Books> pageBean = service.findQuery(category, bookName, currentPage, pageSize);
        System.out.println(pageBean);
        request.setAttribute("category", category);
        request.setAttribute("pb", pageBean);
        request.getRequestDispatcher("/product_list.jsp").forward(request, response);
    }

    public void findBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_str = request.getParameter("id");
        int id;
        if (id_str != null) {
            id = Integer.parseInt(id_str);
        } else {
//            id=0;
            request.setAttribute("error", "Id is wrong");
            request.getRequestDispatcher("/book/showBook").forward(request, response);
            return;
        }
        Books book = service.findBookById(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }

    public void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> bookName = request.getParameterMap();
        Books book = new Books();
        try {
            BeanUtils.populate(book, bookName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.editBook(book);
        request.getRequestDispatcher("/book/showBook").forward(request, response);
    }

    public void delBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id_str = request.getParameter("id");
        String name = request.getParameter("name");
        int id=Integer.parseInt(id_str);
        service.deleteByIdAndName(id,name);
        ResultInfo info=new ResultInfo();
        info.setData("删除成功");
        String json = writeJsonAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(json);
    }
}
