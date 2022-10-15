package com.turkovaleksey.spring.springboot_rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class MyController {
    @GetMapping("/admin")
    public String getAdminPage(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            session.setAttribute("access", "y");
            response.sendRedirect("http://localhost:3000/admin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        HttpSession session = request.getSession(true);
//        session.setAttribute("mySessionAttribute", "someValue");
        return "test";
    }

}
