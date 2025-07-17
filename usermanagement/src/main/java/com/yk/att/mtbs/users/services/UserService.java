package com.yk.att.mtbs.users.services;

import com.yk.att.mtbs.users.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    User registerUser(User user) throws UserAlreadyExistsException;

    String login(String username, String password);

    boolean logout(String token);


}
