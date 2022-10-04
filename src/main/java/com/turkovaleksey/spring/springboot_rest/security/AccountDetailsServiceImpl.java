package com.turkovaleksey.spring.springboot_rest.security;

import com.turkovaleksey.spring.springboot_rest.dao.api.AccountDao;
import com.turkovaleksey.spring.springboot_rest.dao.entity.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("accountDetailsServiceImpl")
public class AccountDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountDao dao;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Account account = dao.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("Account doesn't exists"));
        return SecurityAccount.fromAccount(account);
    }
}
