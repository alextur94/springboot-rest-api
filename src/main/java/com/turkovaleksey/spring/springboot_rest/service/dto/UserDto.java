package com.turkovaleksey.spring.springboot_rest.service.dto;

import com.turkovaleksey.spring.springboot_rest.repository.model.account.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
public class UserDto extends AbstractDto<Integer> {
    private String username;
    private String email;
    private List<String> roles;

    public UserDto(Integer id, String username, String email, List<String> roles) {
        super.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
