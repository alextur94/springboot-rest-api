package com.turkovaleksey.spring.springboot_rest.dao.api;

import com.turkovaleksey.spring.springboot_rest.dao.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountDao extends JpaRepository<Account, Integer> {
    Optional<Account> findByLogin(String login);
}
