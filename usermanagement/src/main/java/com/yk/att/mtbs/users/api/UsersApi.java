package com.yk.att.mtbs.users.api;

import com.yk.att.mtbs.users.dto.LoginRequest;
import com.yk.att.mtbs.users.dto.UserDto;
import com.yk.att.mtbs.users.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface UsersApi {

    ResponseEntity<UserResponseDto> register(UserDto user);

    ResponseEntity<Map<String,String>> login(LoginRequest request);

    ResponseEntity<?> logout(String token);

}
