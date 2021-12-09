package com.study.springmvc.controller;

import com.study.springmvc.domain.Account;
import com.study.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    private static final String SUCCESS = "success";

    /**
     *请求参数绑定入门
     */
    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("testParam");
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        return SUCCESS;
    }

    /**
     *请求参数绑定实体类型，把数据类型封装到JavaBean的类中
     *
     * SpringMVC会按请求参数名和POJO属性名进行自动匹配
     * 自动为该对象填充属性值，并支持级联属性 如本例：account.uname
     *
     */
    @RequestMapping("/saveAccount")
    public String testAccount(Account account) {
        System.out.println("saveAccount");
        System.out.println(account);
        return SUCCESS;
    }

    /**
     *自定义类型转换器
     *
     */
    @RequestMapping("/saveUser")
    public String testUser(User user) {
        System.out.println("saveUser");
        System.out.println(user);
        return SUCCESS;
    }

    /**
     *原生Servlet API
     *
     */
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("testServletAPI");

        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext context = session.getServletContext();
        System.out.println(context);

        System.out.println(response);
        return SUCCESS;
    }
}
