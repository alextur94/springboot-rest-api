package com.turkovaleksey.spring.springboot_rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class MyController {

    @GetMapping("/admin")
    public String getAdminPage(HttpServletResponse response) {
        try {
            response.sendRedirect("http://localhost:3000/admin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
