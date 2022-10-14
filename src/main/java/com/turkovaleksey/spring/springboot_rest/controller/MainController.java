package com.turkovaleksey.spring.springboot_rest.controller;

import com.turkovaleksey.spring.springboot_rest.repository.model.account.Role;
import com.turkovaleksey.spring.springboot_rest.repository.model.account.User;
import com.turkovaleksey.spring.springboot_rest.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@RestController
public class MainController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getMainPage(HttpServletResponse response) {
        try {
            response.sendRedirect("http://localhost:3000/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/users")
    public String getUsersPage() {
        return "<h1>User page</h1>";
    }

    @GetMapping("/user")
    public String getUserPage(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return "<h3> USER PAGE. username : " + principal.getName() + ", email : " + user.getEmail() + "</h3>";
    }

}
