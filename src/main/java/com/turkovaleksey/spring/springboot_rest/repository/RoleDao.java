package com.turkovaleksey.spring.springboot_rest.repository;

import com.turkovaleksey.spring.springboot_rest.entity.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
}
