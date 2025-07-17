package com.yk.att.mtbs.users.mappers;

import com.yk.att.mtbs.users.dto.RoleDto;
import com.yk.att.mtbs.users.model.Role;
import com.yk.att.mtbs.users.services.RoleService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto map(Role role, @Context RoleService roleService);
    Role map(RoleDto roleDto, @Context RoleService roleService);
}
