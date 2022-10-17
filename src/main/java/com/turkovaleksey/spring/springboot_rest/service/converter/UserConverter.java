package com.turkovaleksey.spring.springboot_rest.service.converter;

import com.turkovaleksey.spring.springboot_rest.repository.model.account.Role;
import com.turkovaleksey.spring.springboot_rest.repository.model.account.User;
import com.turkovaleksey.spring.springboot_rest.service.converter.api.Converter;
import com.turkovaleksey.spring.springboot_rest.service.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserConverter implements Converter<User, UserDto> {
    @Override
    public User convert(UserDto entity) {
        return null;
    }

    @Override
    public UserDto convert(User entity) {
        return new UserDto(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                convertRoleToList(entity.getRoles())
        );
    }
    
    private List<String> convertRoleToList(Collection<Role> roles) {
        List<String> listRoles = new ArrayList<>();
        for (Role role : roles) {
            listRoles.add(role.getName());
        }
        return listRoles;
    }

}
