package com.turkovaleksey.spring.springboot_rest.service.api;

import com.turkovaleksey.spring.springboot_rest.repository.model.employee.Employee;

import java.util.List;

public interface EmployeeService extends Service<Employee, Integer> {
    List<String> getAllPhoneBySalary(Integer salary);
}
