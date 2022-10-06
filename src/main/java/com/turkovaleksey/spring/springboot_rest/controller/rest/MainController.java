package com.turkovaleksey.spring.springboot_rest.controller.rest;

import com.turkovaleksey.spring.springboot_rest.entity.account.User;
import com.turkovaleksey.spring.springboot_rest.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getMainPage() {
        return "<h1>Main page</h1>";
    }

    @GetMapping("/user/")
    public String getUserPage(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return "USER PAGE. username : " + principal.getName() + ", email : " + user.getEmail();
    }

    @GetMapping("/admin/")
    public String getAdminPage(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return "<h3> ADMIN PAGE. username : " + principal.getName() + ", email : " + user.getEmail() + "</h3>";
    }

}
