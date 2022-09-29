package com.turkovaleksey.spring.springboot_rest.service.api;

import com.turkovaleksey.spring.springboot_rest.dao.entity.Employee;

import java.util.List;

public interface EmployeeService extends Service<Employee, Integer>{
    List<String> getAllPhone();
}
