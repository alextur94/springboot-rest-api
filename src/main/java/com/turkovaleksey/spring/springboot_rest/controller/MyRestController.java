package com.turkovaleksey.spring.springboot_rest.controller;

import com.turkovaleksey.spring.springboot_rest.dao.entity.Employee;
import com.turkovaleksey.spring.springboot_rest.service.api.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class MyRestController {

    @Autowired
    private Service service;

    @GetMapping("/")
    public List<Employee> showAllEmployees() {
        List<Employee> list = service.getAll();
        return list;
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = (Employee) service.getByID(id);
        return employee;
    }

    @PostMapping("/")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        service.saveOrUpdate(employee);
        return employee;
    }

    @PutMapping("/")
    public Employee updateEmployee(@RequestBody Employee employee) {
        service.saveOrUpdate(employee);
        return employee;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        service.deleteById(id);
        return "Employee with ID = " + id + " was deleted";
    }

}
