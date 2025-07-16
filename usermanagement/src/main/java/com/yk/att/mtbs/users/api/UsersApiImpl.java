package com.yk.att.mtbs.users.api;

import com.yk.att.mtbs.users.dto.UserDto;
import com.yk.att.mtbs.users.mappers.RoleMapper;
import com.yk.att.mtbs.users.mappers.UserMapper;
import com.yk.att.mtbs.users.services.UserAlreadyExistsException;
import com.yk.att.mtbs.users.services.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UsersApiImpl implements UsersApi {

    private final UserService userService;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private static final Logger logger = LoggerFactory.getLogger(UsersApiImpl.class);

    @Autowired
    public UsersApiImpl(UserService userService, UserMapper userMapper, RoleMapper roleMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody UserDto user) {
        UserDto newUser;
        logger.info("userDto: {}", user);

        try {
            newUser = userMapper.map(userService.registerUser(userMapper.map(user)));
        } catch (UserAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(newUser);
    }


    @Override
    @PostMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok(null);
//        try {
//            return ResponseEntity.ok(null);
//
//        } catch (BadCredentialsException e) {
//            ErrorResponse error = new ErrorResponseException(
//                    HttpStatus.UNAUTHORIZED
//            );
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
//
//        } catch (DisabledException e) {
//            ErrorResponse error = new ErrorResponseException(
//                    HttpStatus.FORBIDDEN
//            );
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
//
//        } catch (Exception e) {
//            ErrorResponse error = new ErrorResponseException(
//                    HttpStatus.INTERNAL_SERVER_ERROR
//            );
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
//        }
    }

    @Override
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token) {
        // For JWT, logout is typically handled client-side by removing the token
        // You could implement token blacklisting here if needed
        return ResponseEntity.ok().body("Logged out successfully");
    }
}
