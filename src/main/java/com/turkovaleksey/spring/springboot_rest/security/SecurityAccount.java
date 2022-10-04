package com.turkovaleksey.spring.springboot_rest.security;

import com.turkovaleksey.spring.springboot_rest.dao.entity.account.Account;
import com.turkovaleksey.spring.springboot_rest.dao.entity.account.Status;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class SecurityAccount implements UserDetails {

    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;
    private final boolean isActive;

    public SecurityAccount(String username, String password, List<SimpleGrantedAuthority> authorities, boolean isActive) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.isActive = isActive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public static UserDetails fromAccount(Account account) {
        return new User(
                account.getLogin(), account.getPassword(),
                account.getStatus().equals(Status.ACTIVE),
                account.getStatus().equals(Status.ACTIVE),
                account.getStatus().equals(Status.ACTIVE),
                account.getStatus().equals(Status.ACTIVE),
                account.getRole().getAuthorities()
        );
    }
}