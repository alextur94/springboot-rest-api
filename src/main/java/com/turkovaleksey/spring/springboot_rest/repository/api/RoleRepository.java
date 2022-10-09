package com.turkovaleksey.spring.springboot_rest.repository.api;

import com.turkovaleksey.spring.springboot_rest.repository.model.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
