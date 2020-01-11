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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User form = CommonUtils.toBean(request.getParameterMap(),User.class);
        Map<String,String> errors = new HashMap<>();

        String username = form.getUsername();
        if (username == null || username.trim().isEmpty()) {
            errors.put("username", "用户名不能为空！");
        } else if (username.length() < 3 || username.length() > 20) {
            errors.put("username", "用户名长度在3-20之间");
        }

        String password = form.getPassword();
        if (password == null || password.trim().isEmpty()) {
            errors.put("password", "密码不能为空！");
        } else if (password.length() < 3 || password.length() > 20) {
            errors.put("password", "密码长度在3-20之间");
        }

        System.out.println(form.getUsername());
        System.out.println(form.getPassword());
        System.out.println(form.getVerifyCode());
        System.out.println(request.getSession().getAttribute("session_vcod"));

        if (!form.getVerifyCode().equalsIgnoreCase(
                (String)request.getSession()
                        .getAttribute("session_vcod")
        )) {
            errors.put("verifycode", "验证码输入错误！");
        }

        if (errors != null && errors.size() > 0) {
            request.setAttribute("errors", errors);
            request.setAttribute("user", form);
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }



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
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
        }
    }
}
