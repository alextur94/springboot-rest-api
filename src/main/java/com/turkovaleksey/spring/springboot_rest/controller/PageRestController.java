package com.turkovaleksey.spring.springboot_rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/info")
public class PageRestController {
    @GetMapping("/username")
    public String getActualUser(Principal principal) {
        return principal.getName();
    }
}
