package com.turkovaleksey.spring.springboot_rest.service.impl;

import com.turkovaleksey.spring.springboot_rest.dao.api.EmployeeDao;
import com.turkovaleksey.spring.springboot_rest.dao.entity.Employee;
import com.turkovaleksey.spring.springboot_rest.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;

    @Override
    public List<Employee> getAll() {
        return dao.findAll();
    }

    @Override
    public void saveOrUpdate(Employee entity) {
        dao.save(entity);
    }

    @Override
    public Employee getByID(Integer id) {
        Optional<Employee> employee = dao.findById(id);
        return employee.orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional
    public List<String> getAllPhoneBySalary(Integer salary) {
        return (List<String>) dao.findPhoneWhereSalaryMore(salary);
    }


}
