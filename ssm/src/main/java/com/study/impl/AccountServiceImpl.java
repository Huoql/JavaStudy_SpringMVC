package com.study.impl;

import com.study.dao.AccountMapper;
import com.study.domain.Account;
import com.study.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService
{
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户...");
        List<Account> accountList = accountMapper.findAll();
        return accountList;
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存账户信息...");
        accountMapper.saveAccount(account);
    }
}
