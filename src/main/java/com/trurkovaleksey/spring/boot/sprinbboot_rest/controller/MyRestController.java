package com.trurkovaleksey.spring.boot.sprinbboot_rest.controller;


import com.trurkovaleksey.spring.boot.sprinbboot_rest.entity.Employee;
import com.trurkovaleksey.spring.boot.sprinbboot_rest.srevice.api.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private Service service;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> list = service.getAll();
        return list;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = (Employee) service.getByID(id);
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        service.saveOrUpdate(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        service.saveOrUpdate(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        service.deleteById(id);
        return "Employee with ID = " + id + " was deleted";
    }


}
