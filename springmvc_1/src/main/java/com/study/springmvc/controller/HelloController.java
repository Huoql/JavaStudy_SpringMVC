package com.study.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//控制器类
@Controller
@RequestMapping(path="/user")
public class HelloController {

    private static final String SUCCESS = "success";

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("Hello SpringMVC");
        return SUCCESS;
    }

    /**
     * method = RequestMethod.POST
     *
     * @return
     */
    @RequestMapping(value="/testRequestMapping",params = {"username=heihei"},headers = {"Accept-Language=zh-CN,zh;q=0.9"})
    public String testRequestMapping() {
        System.out.println("测试RequestMapping注解");
        return SUCCESS;
    }
}
