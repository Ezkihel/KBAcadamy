package com.example.restapi.repository;

import com.example.restapi.model.Role;
import com.example.restapi.model.RolesName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(RolesName roleName);
}
