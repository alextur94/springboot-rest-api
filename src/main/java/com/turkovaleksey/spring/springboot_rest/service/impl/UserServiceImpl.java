package com.turkovaleksey.spring.springboot_rest.service.impl;

import com.turkovaleksey.spring.springboot_rest.repository.api.UserRepository;
import com.turkovaleksey.spring.springboot_rest.repository.model.account.Role;
import com.turkovaleksey.spring.springboot_rest.repository.model.account.User;
import com.turkovaleksey.spring.springboot_rest.service.api.UserService;
import com.turkovaleksey.spring.springboot_rest.service.converter.UserConverter;
import com.turkovaleksey.spring.springboot_rest.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private UserRepository userRepository;
    private UserConverter userConverter;

    @Autowired
    public void setRepository(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            usersDto.add(userConverter.convert(user));
        }
        return usersDto;
    }

    @Override
    public void saveOrUpdate(UserDto entity) {
        User user = userConverter.convert(entity);
        userRepository.save(user);
    }

    @Override
    public UserDto getByID(Integer id) {
        Optional<User> user = userRepository.findById(id);
        User actualUser = user.orElse(null);
        UserDto userDto = null;
        if (actualUser != null) {
            userDto = userConverter.convert(actualUser);
        }
        return userDto;
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }
}
