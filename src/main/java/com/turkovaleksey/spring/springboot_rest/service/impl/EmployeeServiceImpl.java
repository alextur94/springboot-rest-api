package com.turkovaleksey.spring.springboot_rest.service.impl;

import com.turkovaleksey.spring.springboot_rest.dao.api.EmployeeDao;
import com.turkovaleksey.spring.springboot_rest.dao.entity.Employee;
import com.turkovaleksey.spring.springboot_rest.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;

    @Override
    @Transactional
    public List<Employee> getAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Employee entity) {
        dao.save(entity);
    }

    @Override
    @Transactional
    public Employee getByID(Integer id) {
        return dao.getById(id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional
    public List<String> getAllPhone() {
        return (List<String>) dao.findAllPhone();
    }


}
