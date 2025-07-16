package com.yk.att.mtbs.users.services;

import com.yk.att.mtbs.users.model.User;
import com.yk.att.mtbs.users.persistence.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        logger.info("User: {}", user);
        var existingUser = userRepository.findById(user.getUsername());
        if(existingUser.isPresent()) {
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);

    }

    @Override
    public ResponseEntity<?> login() {
        return null;
    }

    @Override
    public ResponseEntity<?> logout(String token) {
        return null;
    }


}
