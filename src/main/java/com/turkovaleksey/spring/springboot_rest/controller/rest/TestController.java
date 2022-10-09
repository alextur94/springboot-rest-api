package com.turkovaleksey.spring.springboot_rest.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/users")
    public Boolean getAllUsers() {
        return true;
    }
}
