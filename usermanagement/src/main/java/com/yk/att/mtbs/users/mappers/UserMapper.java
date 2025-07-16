package com.yk.att.mtbs.users.mappers;

import com.yk.att.mtbs.users.dto.UserDto;
import com.yk.att.mtbs.users.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface UserMapper {
    UserDto map(User user);
    User map(UserDto userDto);
}