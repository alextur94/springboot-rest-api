package com.turkovaleksey.spring.springboot_rest.repository.api;

import com.turkovaleksey.spring.springboot_rest.repository.model.account.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
