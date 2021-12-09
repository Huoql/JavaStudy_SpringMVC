package com.study.test;

import com.study.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSSM {

    @Test
    public void test1() {
        //加载Spring配置文件
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        AccountService as = (AccountService) ioc.getBean("accountService");
        //调用方法
        as.findAll();
    }
}
