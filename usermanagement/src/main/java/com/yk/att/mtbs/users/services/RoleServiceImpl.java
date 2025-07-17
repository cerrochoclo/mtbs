package com.yk.att.mtbs.users.services;

import com.yk.att.mtbs.users.model.Role;
import com.yk.att.mtbs.users.persistence.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleRepository.findById(Integer.toString(id))
                .orElseThrow(() -> new RuntimeException("Role not found with ID " + id));
    }
}
