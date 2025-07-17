package com.yk.att.mtbs.users.services;

import com.yk.att.mtbs.users.api.UsersApiImpl;
import com.yk.att.mtbs.users.model.Role;
import com.yk.att.mtbs.users.persistence.RoleRepository;
import com.yk.att.mtbs.users.persistence.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userOptional =  userRepository.findByUsername(username);
        userOptional.ifPresent(user -> logger.info(user.toString()));
       return userOptional.map(user -> User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // must be hashed
                .roles(user.getRole().getName())// or fetch from DB if you store roles
                .build())
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
