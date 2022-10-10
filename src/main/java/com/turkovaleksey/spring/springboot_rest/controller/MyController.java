package com.turkovaleksey.spring.springboot_rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyController {
    @GetMapping("/admin")
    public String getAdminPage() {
        return "redirect:/localhost:3000/admin";
    }

}
