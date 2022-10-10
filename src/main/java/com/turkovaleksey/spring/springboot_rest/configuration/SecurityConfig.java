package com.turkovaleksey.spring.springboot_rest.configuration;

//import com.turkovaleksey.spring.springboot_rest.service.impl.UserService;
import com.turkovaleksey.spring.springboot_rest.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;
import java.util.Arrays;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //Разобраться!!!
                .cors() //Разобраться!!!
                .and()
                .authorizeRequests()
                .antMatchers("/users/**").permitAll()
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/**").permitAll()
//                .antMatchers(HttpMethod.GET,"/api/**").hasAuthority("READ_EMPLOYEES")
//                .antMatchers(HttpMethod.PUT,"/api/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/api/**").hasRole("ADMIN")
                .and()
                .formLogin()
//                .loginPage("http://localhost:3000/login")
//                .defaultSuccessUrl("/")
                .and()
                .logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/logout-success")
        ;
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "PUT", "DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    //Method 4 (DaoAuthenticationProvide)
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    //Method 3.2 with create Users (jdbcAuth)
//    @Bean
//    public JdbcUserDetailsManager user(DataSource dataSource) {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{bcrypt}$2a$12$oFp13ZWgmMAW4h4j44j03.tCMg21lw/dvBC21ZkdkAhh30.9LpOU2")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{bcrypt}$2a$12$qyOg7cbqDKraZUJhQdjmb.PWCdQmZcXiRE02sLr4ggK75O0y6JOTy")
//                .roles("ADMIN", "USER")
//                .build();
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        if (jdbcUserDetailsManager.userExists(user.getUsername())) {
//            jdbcUserDetailsManager.deleteUser(user.getUsername());
//        }
//        if (jdbcUserDetailsManager.userExists(admin.getUsername())) {
//            jdbcUserDetailsManager.deleteUser(admin.getUsername());
//        }
//        jdbcUserDetailsManager.createUser(user);
//        jdbcUserDetailsManager.createUser(admin);
//        return jdbcUserDetailsManager;
//    }

    //Method 3.1 (jdbcAuth)
//    @Bean
//    public JdbcUserDetailsManager user(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    //Method 2 (In memory)
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{bcrypt}$2a$12$Nsujpijmr4sVugPbeHpYtOMheJ85LRVvt/0uWns9/0QduBhka6OJ.") //pass : 2
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{bcrypt}$2a$12$FE7dHFF8vDokcUSfyg52XeNBPbQI09apqSZTXxrkkxE26exoiJiT2") //pass : 1
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }

}
