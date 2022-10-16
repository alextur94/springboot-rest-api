package com.turkovaleksey.spring.springboot_rest.controller.entity;

import com.turkovaleksey.spring.springboot_rest.controller.api.ControllerAPI;
import com.turkovaleksey.spring.springboot_rest.repository.model.employee.Employee;
import com.turkovaleksey.spring.springboot_rest.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController implements ControllerAPI<Employee, Integer> {

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
//    @PreAuthorize("hasAuthority('developers:read')")
    @GetMapping("/")
    public List<Employee> getAll() {
        List<Employee> list = employeeService.getAll();
        return list;
    }

    @Override
//    @PreAuthorize("hasAuthority('developers:write')")
    @PutMapping("/")
    public Employee saveOrUpdate(@RequestBody Employee employee) {
        employeeService.saveOrUpdate(employee);
        return employee;
    }

    @Override
//    @PreAuthorize("hasAuthority('developers:read')")
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id) {
        Employee employee = employeeService.getByID(id);
        return employee;
    }

    @Override
//    @PreAuthorize("hasAuthority('developers:write')")
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        employeeService.deleteById(id);
        return "Employee with ID = " + id + " was deleted";
    }

//    @GetMapping("/salary/{salary}")
//    public List<String> getAllPhoneBySalary(@PathVariable Integer salary) {
//        List<String> list = service.getAllPhoneBySalary(salary);
//        return list;
//    }

}
