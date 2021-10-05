package web.mobileleleapp.models.service;


import web.mobileleleapp.models.entities.enums.Role;

public class UserRoleServiceModel {

    private Long id;
    private Role role;

    public UserRoleServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
