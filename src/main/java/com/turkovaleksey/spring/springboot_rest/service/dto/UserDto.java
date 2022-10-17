package com.turkovaleksey.spring.springboot_rest.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto extends AbstractDto<Integer> {
    private String username;
    private String password;
    private String email;
    private List<String> roles;

    public UserDto() {
    }

    public UserDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserDto(Integer id, String username, String email, List<String> roles) {
        super.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
