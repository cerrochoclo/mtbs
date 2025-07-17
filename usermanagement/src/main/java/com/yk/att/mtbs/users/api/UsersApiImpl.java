package com.yk.att.mtbs.users.api;

import com.yk.att.mtbs.users.dto.LoginRequest;
import com.yk.att.mtbs.users.dto.UserDto;
import com.yk.att.mtbs.users.dto.UserResponseDto;
import com.yk.att.mtbs.users.mappers.RoleMapper;
import com.yk.att.mtbs.users.mappers.UserMapper;
import com.yk.att.mtbs.users.services.RoleService;
import com.yk.att.mtbs.users.services.UserAlreadyExistsException;
import com.yk.att.mtbs.users.services.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersApiImpl implements UsersApi {

    private final UserService userService;
    private final UserMapper userMapper;
    private final RoleService roleService;
    private static final Logger logger = LoggerFactory.getLogger(UsersApiImpl.class);

    @Autowired
    public UsersApiImpl(UserService userService, UserMapper userMapper, RoleMapper roleMapper, RoleService roleService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.roleService = roleService;
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody UserDto user) {
        UserDto newUser;
        logger.info("userDto: {}", user);

        try {
            newUser = userMapper.map(userService.registerUser(userMapper.map(user, roleService)));
        } catch (UserAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(new UserResponseDto(newUser.getUsername(), newUser.getName(), newUser.getEmail()));
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@Valid @RequestBody LoginRequest request) {
        try {
            return ResponseEntity.ok(Map.of(
                    "token",
                    userService.login(request.username,request.password)));
        } catch (AuthenticationException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("Error","Invalid credentials"));
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }


    @Override
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token) {
        // For JWT, logout is typically handled client-side by removing the token
        // You could implement token blacklisting here if needed
        return ResponseEntity.ok().body("Logged out successfully");
    }
}
