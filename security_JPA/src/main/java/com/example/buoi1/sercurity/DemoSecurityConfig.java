package com.example.buoi1.sercurity;

import com.example.buoi1.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //authenticationProvider bean definition
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService); //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
        return auth;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configure -> configure
                        /**
                         * /leader/**: tức là sau /leader/ thì mọi cái khác đều được truy cập
                         * hasrole: là có 1 role
                         * hasAnyRole: là có nhiều role
                         * */
                        .requestMatchers("/demo/leader/**").hasRole("MANAGER")
                        .requestMatchers("/demo/month/**").hasAnyRole("EMPLOYEE", "MANAGER")
                        .requestMatchers("/demo/system/**").hasRole("ADMIN")
                        .anyRequest().authenticated())// yêu cầu phải đăng nhạp
                .formLogin(form -> form.loginPage("/login/showMyLoginPage") // đường dẫn tới trang login
                        .loginProcessingUrl("/authenticateUser") // cấu hình lại đường dẫn để đăng nhập
                        .permitAll() // permit all tức là có thể truy cập mà không cần đăng nhập
                )
                .logout(logout -> logout.permitAll())
                .exceptionHandling(exc ->
                        exc.accessDeniedPage("/demo/acces-denied"));

        return httpSecurity.build();
    }


}
