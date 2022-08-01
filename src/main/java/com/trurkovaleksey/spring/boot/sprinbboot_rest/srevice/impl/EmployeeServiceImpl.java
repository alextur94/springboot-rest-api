package com.trurkovaleksey.spring.boot.sprinbboot_rest.srevice.impl;

import com.trurkovaleksey.spring.boot.sprinbboot_rest.dao.api.Dao;
import com.trurkovaleksey.spring.boot.sprinbboot_rest.entity.Employee;
import com.trurkovaleksey.spring.boot.sprinbboot_rest.srevice.api.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class EmployeeServiceImpl implements Service<Employee> {

    @Autowired
    private Dao dao;

    @Override
    @Transactional
    public List<Employee> getAll() {
        return dao.gelAll();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Employee entity) {
        dao.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public Employee getByID(Integer id) {
        return (Employee) dao.getByID(id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }


}
