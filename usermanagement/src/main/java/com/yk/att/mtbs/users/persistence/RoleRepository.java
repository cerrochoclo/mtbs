package com.yk.att.mtbs.users.persistence;

import com.yk.att.mtbs.users.model.Role;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "role")
public interface RoleRepository extends JpaRepository<Role, String> {
}
