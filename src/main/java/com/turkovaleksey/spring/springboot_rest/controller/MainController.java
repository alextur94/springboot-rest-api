package com.turkovaleksey.spring.springboot_rest.controller;

//import com.turkovaleksey.spring.springboot_rest.service.impl.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {

//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping("/")
    public String getMainPage() {
        return "<h1>Main page</h1>";
    }

    @GetMapping("/user")
    public String getUserPage(Principal principal) {
//        User user = userService.findByUsername(principal.getName());
//        return "<h3> USER PAGE. username : " + principal.getName() + ", email : " + user.getEmail() + "</h3>";
        return "<h1>User page</h1>";
    }

    @GetMapping("/admin")
    public String getAdminPage(Principal principal) {
//        User user = userService.findByUsername(principal.getName());
//        return "<h3> ADMIN PAGE. username : " + principal.getName() + ", email : " + user.getEmail() + "</h3>";
        return "<h1>Admin page</h1>";
    }

    @GetMapping("/logout-success")
    public String logoutSuccess() {
        return "Logout success";
    }

}
