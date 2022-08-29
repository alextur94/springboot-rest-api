package com.trurkovaleksey.spring.boot.sprinbboot_rest.dao.impl;

import com.trurkovaleksey.spring.boot.sprinbboot_rest.dao.api.EmployeeDao;
import com.trurkovaleksey.spring.boot.sprinbboot_rest.dao.entity.Employee;
import javax.persistence.EntityManager;

//JPA
import javax.persistence.Query;

//Hibernate
//import org.hibernate.Session;
//import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> gelAll() {
        //JPA
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employeeList = query.getResultList();

        //Hibernate
//        Session session = entityManager.unwrap(Session.class);
//        List<Employee> employeeList = session.createQuery("from Employee", Employee.class).getResultList();

        return employeeList;
    }

    @Override
    public void saveOrUpdate(Employee entity) {
        //JPA
        Employee employee = entityManager.merge(entity);
        entity.setId(employee.getId());

        //Hibernate
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(entity);
    }

    @Override
    public Employee getByID(Integer id) {
        //JPA
        Employee employee = entityManager.find(Employee.class, id);

        //Hibernate
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteById(Integer id) {
        //JPA
        Query query = entityManager.createQuery("delete from Employee where id =:employeeId");

        //Hibernate
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");

        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
