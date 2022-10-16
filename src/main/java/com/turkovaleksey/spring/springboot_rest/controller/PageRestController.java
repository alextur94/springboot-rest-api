package com.turkovaleksey.spring.springboot_rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/info")
public class PageRestController {
    @GetMapping("/access")
    public Boolean getActualUser() {
        return true;
    }
}
