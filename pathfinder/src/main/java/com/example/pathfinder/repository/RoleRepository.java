package com.example.pathfinder.repository;

import com.example.pathfinder.model.entity.Role;
import com.example.pathfinder.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role,Long> {

    Role findByRole(RoleEnum role);
}
