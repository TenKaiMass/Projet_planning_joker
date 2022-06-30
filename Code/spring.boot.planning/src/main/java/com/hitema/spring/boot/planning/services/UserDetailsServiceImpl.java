package com.hitema.spring.boot.planning.services;

import com.hitema.spring.boot.planning.entities.User;
import com.hitema.spring.boot.planning.repositories.UserRepository;
import com.hitema.spring.boot.planning.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nom)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(nom);
        System.out.println(user.getNom());

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }

}
