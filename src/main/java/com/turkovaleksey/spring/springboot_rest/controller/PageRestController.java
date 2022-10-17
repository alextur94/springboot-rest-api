package com.turkovaleksey.spring.springboot_rest.controller;

import com.turkovaleksey.spring.springboot_rest.repository.model.account.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;


@RestController
//@RequestMapping("/info")
public class PageRestController {
//    @GetMapping("/access")
//    public Boolean getActualUser() {
//        return true;
//    }

    @GetMapping("/user")
    public String getUserPage(HttpServletRequest request, Principal principal) {
//        User user = userService.findByUsername(principal.getName());
//        String username = principal.getName();
//        HttpSession session = request.getSession();
//        session.setAttribute("name", username);
//        session.setAttribute("email", user.getEmail());
        return "user";
    }
}
