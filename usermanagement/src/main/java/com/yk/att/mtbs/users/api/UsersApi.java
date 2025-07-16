package com.yk.att.mtbs.users.api;

import com.yk.att.mtbs.users.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UsersApi {

    ResponseEntity<UserDto> register(UserDto user);

    ResponseEntity<?> login();

    ResponseEntity<?> logout(String token);

}
