package com.example.pathfinder.model.entity;


import com.example.pathfinder.model.enums.LevelEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private String username;
    private String fullName;
    private Integer age;
    private String password;
    private String email;
    private Set<Role> roles;
    private LevelEnum level;


    public UserEntity() {
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(nullable = false, name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(nullable = false, unique = true)
    @Size(min = 2)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    @Size(min = 2)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Enumerated(EnumType.STRING)
    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }
}
