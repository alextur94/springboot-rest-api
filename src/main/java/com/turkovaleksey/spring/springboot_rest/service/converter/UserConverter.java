package com.turkovaleksey.spring.springboot_rest.service.converter;

import com.turkovaleksey.spring.springboot_rest.repository.model.account.Role;
import com.turkovaleksey.spring.springboot_rest.repository.model.account.User;
import com.turkovaleksey.spring.springboot_rest.service.converter.api.Converter;
import com.turkovaleksey.spring.springboot_rest.service.dto.UserDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserConverter implements Converter<User, UserDto> {
    @Override
    public User convert(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                passwordEncoder(userDto.getPassword()),
                userDto.getEmail()
        );
    }

    @Override
    public UserDto convert(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                convertRoleToList(user.getRoles())
        );
    }
    
    private List<String> convertRoleToList(Collection<Role> roles) {
        List<String> listRoles = new ArrayList<>();
        for (Role role : roles) {
            listRoles.add(role.getName());
        }
        return listRoles;
    }

    private String passwordEncoder(String password) {
        return new BCryptPasswordEncoder(12).encode(password);
    }

}
