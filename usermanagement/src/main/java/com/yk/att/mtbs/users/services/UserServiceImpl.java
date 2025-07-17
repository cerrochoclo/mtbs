package com.yk.att.mtbs.users.services;

import com.yk.att.mtbs.users.model.User;
import com.yk.att.mtbs.users.persistence.UserRepository;
import com.yk.att.mtbs.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        logger.info("User: {}", user);
        var existingUser = userRepository.findById(user.getUsername());
        if(existingUser.isPresent()) {
            throw new UserAlreadyExistsException();
        }
        User passwordEncryptedUser = new User(user.getUsername(),
                user.getName(),
                user.getEmail(),
                passwordEncoder.encode(user.getPassword()),
                user.getRole());
        return userRepository.save(passwordEncryptedUser);

    }

    @Override
    public String login(String username, String password) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

        List<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority) // e.g. "ROLE_USER"
                .map(role -> role.startsWith("ROLE_") ? role.substring(5) : role) // strip "ROLE_"
                .toList();
        return jwtUtil.generateToken(username, roles.getFirst());
    }

    @Override
    public boolean logout(String token) {
        return false;
    }


}
