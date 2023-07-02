package com.example.buoi1.sercurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails sonpt = User.builder().username("sonpt").password("{noop}12123").roles("EMPLOYEE").build();


        UserDetails mary = User.builder().username("mary").password("{noop}12123").roles("EMPLOYEE", "MANAGER").build();

        UserDetails susan = User.builder().username("susan").password("{noop}12123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

        return new InMemoryUserDetailsManager(sonpt, mary, susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configure -> configure.anyRequest().authenticated())// yêu cầu phải đăng nhạp
                .formLogin(form -> form.loginPage("/login/showMyLoginPage") // đường dẫn tới trang login
                        .loginProcessingUrl("/authenticateUser") // cấu hình lại đường dẫn để đăng nhập
                        .permitAll() // permit all tức là có thể truy cập mà không cần đăng nhập
                )
                .logout(logout -> logout.permitAll());

        return httpSecurity.build();
    }


}
