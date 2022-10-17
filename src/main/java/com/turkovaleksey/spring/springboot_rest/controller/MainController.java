package com.turkovaleksey.spring.springboot_rest.controller;

import com.turkovaleksey.spring.springboot_rest.repository.model.account.User;
import com.turkovaleksey.spring.springboot_rest.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

@Controller
public class MainController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getMainPage(HttpServletResponse response) {
        try {
            response.addHeader("val12", "8080");
            response.sendRedirect("http://localhost:3000/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/admin")
    public String getAdminPage(HttpServletRequest request, HttpServletResponse response, Principal principal) {
        try {
            String username = principal.getName();
//            HttpSession session = request.getSession();
//            session.setAttribute("name", username);
            response.addHeader("val12", "8080");
            request.setAttribute("name", username);
            response.sendRedirect("http://localhost:3000/admin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/user")
    public String getUserPage(HttpServletRequest request, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        String username = principal.getName();
        HttpSession session = request.getSession();
        session.setAttribute("name", username);
        session.setAttribute("email", user.getEmail());
        return "user";
    }

}
