package com.yk.att.mtbs.users.services;

import com.yk.att.mtbs.users.model.User;
import org.springframework.http.ResponseEntity;

public class UserServiceImpl implements UserService {
    @Override
    public ResponseEntity<User> registerUser(User user) {
        return null;
    }

    @Override
    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        return null;
    }
}
