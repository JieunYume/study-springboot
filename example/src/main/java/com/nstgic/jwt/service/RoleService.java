package com.nstgic.jwt.service;

import com.nstgic.jwt.entity.Role;
import com.nstgic.jwt.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

//    INSERT INTO roles (name) VALUES ('ROLE_USER');
//    INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

    @PostConstruct
    public void initRoles() {
        if (roleRepository.findByName(Role.RoleName.ROLE_USER) == null) {
            roleRepository.save(Role.ROLE_USER);
        }
        if (roleRepository.findByName(Role.RoleName.ROLE_ADMIN) == null) {
            roleRepository.save(Role.ROLE_ADMIN);
        }
    }
}
