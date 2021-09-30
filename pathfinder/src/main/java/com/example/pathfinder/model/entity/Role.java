package com.example.pathfinder.model.entity;


import com.example.pathfinder.model.enums.RoleEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    private RoleEnum roles;

    public Role() {
    }



    @Enumerated(EnumType.STRING)
    public RoleEnum getRole() {
        return roles;
    }

    public void setRole(RoleEnum roles) {
        this.roles = roles;
    }
}
