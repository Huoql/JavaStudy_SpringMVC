package com.study.springmvc.controller;

import com.study.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    public static final String SUCCESS = "success";

    /**
     * 返回String,model可以换成ModelMap，用法一致
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("hql");
        user.setPassword("123456");
        user.setAge(23);
        //model对象
        model.addAttribute("user",user);
        return SUCCESS;
    }

    /**
     * 没有返回值
     * 请求转发一次请求，不用编写项目的名称
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid");
        //编写请求转发的程序
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

        //重定向
//        response.sendRedirect(request.getContextPath()+"/index.jsp");

        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //直接进行响应
        response.getWriter().print("你好！");
        return;
    }

    /**
     * 返回ModelAndView，不推荐
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("hql");
        user.setPassword("123456");
        user.setAge(23);
        //把user对象存储到mv对象中，也会把user对象存入到session对象中
        mv.addObject("user",user);
        //跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * Map，返回的是字符串，是第一种方法，推荐
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, User> map) {

        System.out.println("testMap");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("hql");
        user.setPassword("123456");
        user.setAge(23);

        map.put("user",user);

        return SUCCESS;
    }

    /**
     * 关键字方式进行转发或重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {

        System.out.println("testForwardOrRedirect");

        //请求的转发
//        return "forward:/WEB-INF/pages/success.jsp";

        //请求的重定向
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求和响应
     * @return
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax");
        //客户端发送ajax请求，传的是json字符串，后端把json字符串封装到user对象中（导入json依赖）
        System.out.println(user);
        //做响应，模拟查询数据库
        user.setUsername("haha");
        user.setAge(25);
        //做响应
        return user;
    }
}
