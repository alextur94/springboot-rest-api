package com.turkovaleksey.spring.springboot_rest.service.impl;

import com.turkovaleksey.spring.springboot_rest.repository.EmployeeRepository;
import com.turkovaleksey.spring.springboot_rest.entity.Employee;
import com.turkovaleksey.spring.springboot_rest.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeReopsitory(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Employee entity) {
        employeeRepository.save(entity);
    }

    @Override
    public Employee getByID(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<String> getAllPhoneBySalary(Integer salary) {
        return (List<String>) employeeRepository.findPhoneWhereSalaryMore(salary);
    }


}
