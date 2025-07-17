package com.yk.att.mtbs.users.mappers;

import com.yk.att.mtbs.users.dto.UserDto;
import com.yk.att.mtbs.users.model.Role;
import com.yk.att.mtbs.users.model.User;
import com.yk.att.mtbs.users.services.RoleService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "roleId", source = "role.id")
    UserDto map(User user);

    @Mapping(target = "role", source = "roleId")
    User map(UserDto userDto, @Context RoleService roleService);

    default Role map(Integer roleId, @Context RoleService roleService) {
        return roleService.getRoleById(roleId);
    }
}