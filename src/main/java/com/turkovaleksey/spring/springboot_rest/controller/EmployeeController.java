package com.turkovaleksey.spring.springboot_rest.controller;

import com.turkovaleksey.spring.springboot_rest.controller.api.ControllerAPI;
import com.turkovaleksey.spring.springboot_rest.dao.entity.Employee;
import com.turkovaleksey.spring.springboot_rest.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/employees")
public class EmployeeController implements ControllerAPI<Employee, Integer> {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public List<Employee> getAll() {
        List<Employee> list = service.getAll();
        return list;
    }

    @Override
    @PutMapping("/")
    public Employee saveOrUpdate(@RequestBody Employee employee) {
        service.saveOrUpdate(employee);
        return employee;
    }

    @Override
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id) {
        Employee employee = service.getByID(id);
        return employee;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return "Employee with ID = " + id + " was deleted";
    }

    @GetMapping("/phone")
    public List<String> getAllPhone() {
//        List<String> list = service.getAllPhone();
//        return list;
        return null;
    }

}
