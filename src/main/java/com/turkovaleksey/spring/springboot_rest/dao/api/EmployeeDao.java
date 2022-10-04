package com.turkovaleksey.spring.springboot_rest.dao.api;

import com.turkovaleksey.spring.springboot_rest.dao.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
//    @Query("SELECT phone FROM Employee WHERE salary > ?#{[0]}")
//    Collection<String> findPhoneWhereSalaryMore(Integer sal);
    @Query("SELECT phone FROM Employee WHERE salary > :#{#sal}")
    Collection<String> findPhoneWhereSalaryMore(@Param("sal") Integer sal);
}
