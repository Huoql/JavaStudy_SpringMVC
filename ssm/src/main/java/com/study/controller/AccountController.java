package com.study.controller;

import com.study.domain.Account;
import com.study.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 账户Controller
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Map<String,Object> map) {
        System.out.println("表现层：查询所有账户...");

        //调用service的方法
        List<Account> list = accountService.findAll();
        map.put("list",list);
        System.out.println(list);

        return "list";
    }

    @RequestMapping("/saveAccount")
    public void findAll(Account account, HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        System.out.println("表现层：保存账户信息...");

        //调用service的方法
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}
