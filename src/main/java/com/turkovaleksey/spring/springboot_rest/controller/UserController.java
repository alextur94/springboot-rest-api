package com.turkovaleksey.spring.springboot_rest.controller;

import com.turkovaleksey.spring.springboot_rest.controller.api.DefaultController;
import com.turkovaleksey.spring.springboot_rest.repository.model.account.User;
import com.turkovaleksey.spring.springboot_rest.repository.model.employee.Employee;
import com.turkovaleksey.spring.springboot_rest.service.api.EmployeeService;
import com.turkovaleksey.spring.springboot_rest.service.api.UserService;
import com.turkovaleksey.spring.springboot_rest.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data/users")
public class UserController implements DefaultController<UserDto, Integer> {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping("/")
    public List<UserDto> getAll() {
        List<UserDto> list = userService.getAll();
        return list;
    }

    @Override
    @PutMapping("/")
    public UserDto saveOrUpdate(@RequestBody UserDto userDto) {
        userService.saveOrUpdate(userDto);
        return userDto;
    }

    @Override
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Integer id) {
        UserDto user = userService.getByID(id);
        return user;
    }

    @Override
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
        return "User with ID = " + id + " was deleted";
    }

}
