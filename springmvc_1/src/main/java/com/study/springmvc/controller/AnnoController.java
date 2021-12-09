package com.study.springmvc.controller;

import com.study.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 常用注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes("msg") //把msg=123存入到session域中
public class AnnoController {

    public static final String SUCCESS = "success";

    /**
     * 使用@RequestParam注解的常用场景
     * 1. 请求参数与方法参数名称不一致时；
     * 2. 强制要求提交某些参数；
     * 3. 设置请求参数的默认值。
     * 可以通过设置required = false实现添加了注解却可以不提交该请求参数
     * @param username
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "uname", required = false, defaultValue = "hql") String username) {
        System.out.println("testRequestParam");
        System.out.println(username);
        return SUCCESS;
    }

    /**
     * 获取到请求体的内容
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("testRequestBody");
        System.out.println(body);
        return SUCCESS;
    }

    /**
     * @PathVariable注解
     *
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") String id) {
        System.out.println("testPathVariable");
        System.out.println(id);
        return SUCCESS;
    }

    /**
     * 了解
     * @RequestHeader注解用于获取请求头信息
     *
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("accept") String header) {
        System.out.println("testRequestHeader");
        System.out.println(header);
        return SUCCESS;
    }

    /**
     * 了解
     * @CookieValue
     *
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("testCookieValue");
        System.out.println(sessionId);
        return SUCCESS;
    }

    /**
     *@ModelAttribute注解
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("user") User user) {
        System.out.println("testModelAttribute");
        System.out.println(user);
        return SUCCESS;
    }

    @ModelAttribute
    public void showUser(String uname, Map<String,User> map) {
        System.out.println("showUser");
        //通过用户名称uname查找数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("user",user);
    }

    /**
     * 该方法先执行
    @ModelAttribute
    public User showUser(String uname) {
        System.out.println("showUser");
        //通过用户名称uname查找数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }*/

    /**
     * @SessionAttributes注解
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes");
        //底层会存储到request域对象中
        model.addAttribute("msg","123");
        return SUCCESS;
    }

    /**
     * 获取值
     * @param modelMap
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes");
        System.out.println(modelMap.get("msg"));
        return SUCCESS;
    }

    /**
     * 删除值
     * @param
     * @return
     */
    @RequestMapping("/deleteSessionAttributes")
    public String deleteSessionAttributes(SessionStatus status) {
        System.out.println("deleteSessionAttributes");
        status.setComplete();
        return SUCCESS;
    }
}
