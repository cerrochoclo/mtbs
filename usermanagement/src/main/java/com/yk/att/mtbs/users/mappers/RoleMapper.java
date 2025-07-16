package com.yk.att.mtbs.users.mappers;

import com.yk.att.mtbs.users.dto.RoleDto;
import com.yk.att.mtbs.users.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto map(Role role);
    Role map(RoleDto roleDto);
}
