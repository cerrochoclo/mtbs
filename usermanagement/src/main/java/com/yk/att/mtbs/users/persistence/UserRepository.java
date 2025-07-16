package com.yk.att.mtbs.users.persistence;

import com.yk.att.mtbs.users.model.User;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "mtbsuser")
public interface UserRepository  extends JpaRepository<User, String> {
}
