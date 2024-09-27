package com.nstgic.jwt.repository;


import com.nstgic.jwt.entity.Role;
import com.nstgic.jwt.entity.Role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName (RoleName roleName);


}
