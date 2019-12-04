package com.itheima.controller;

import com.itheima.domain.ResultInfo;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class UserController extends BaseController {
    private UserService service=new UserServiceImpl();
    ResultInfo resultInfo=new ResultInfo();
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User login = service.login(username, password);
        if (login!=null){
            request.getSession().setAttribute("userInfo",login);
            resultInfo.setFlag(true);
        }else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("Check your ID & password");
        }
        String json = writeJsonAsString(resultInfo);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }
    public void checkName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        User check=service.checkName(username);
        if (check!=null){
            resultInfo.setFlag(true);
            resultInfo.setData("This ID Could Use");
        }else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("This ID Could not Use");
        }
        String json = writeJsonAsString(resultInfo);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
