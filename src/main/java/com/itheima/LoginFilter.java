package com.itheima;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        Object userInfo = request.getSession().getAttribute("userInfo");
        String uri = request.getRequestURI();
        if (uri.contains(".js")||uri.contains("login.jsp")||uri.contains("menu_search.jsp")||uri.contains("*.png")||uri.contains("*.jpg")
                ||uri.contains("*.gif")||uri.contains("*.css")||uri.contains("head.jsp")||uri.contains("foot.jsp")||uri.contains("/user/checkName")
        ||uri.contains("/user/login")){
            chain.doFilter(request,response);
        }else {
            if (userInfo==null||"".equals(userInfo)){
                request.setAttribute("error_msg","please sign in");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
                return;
            }else {
                chain.doFilter(request,response);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
