package com.study.dao;

import com.study.domain.Account;

import java.util.List;

/**
 * 账户Dao接口
 */
public interface AccountMapper {

    //查询所有用户
    public List<Account> findAll();

    //保存账户信息
    public void saveAccount(Account account);
}
