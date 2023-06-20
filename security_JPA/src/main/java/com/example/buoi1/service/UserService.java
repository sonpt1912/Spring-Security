package com.example.buoi1.service;

import com.example.buoi1.model.User;
import com.example.buoi1.model.UserDetail;
import com.example.buoi1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("khong tim thay gi het");
        }

        return new UserDetail(user);
    }
}
