package cn.itcast.user.web.servlet;

import cn.itcast.user.domain.User;
import cn.itcast.user.service.UserException;
import cn.itcast.user.service.UserService;
import cn.itcast.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User form = CommonUtils.toBean(request.getParameterMap(),User.class);
        UserService userService = new UserService();
        try {
            userService.regist(form);
//            response.getWriter().print("注册成功！");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.getWriter().print("<h1>注册成功</h1><a href='" + request.getContextPath() + "/login.jsp" + "'>注册成功，点击这里跳转登录页面！</a>");
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User form = CommonUtils.toBean(request.getParameterMap(),User.class);
        UserService userService = new UserService();
        try {
            userService.regist(form);
//            response.getWriter().print("注册成功！");
            response.getWriter().print("<h1>注册成功</h1><a href='" + request.getContextPath() + "/User/login.jsp" + "'>注册成功，点击这里跳转登录页面！</a>");
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
            request.getRequestDispatcher("/User/regist.jsp").forward(request,response);
        }
    }
}
