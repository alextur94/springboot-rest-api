package com.turkovaleksey.spring.springboot_rest.repository;

import com.turkovaleksey.spring.springboot_rest.entity.account.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
