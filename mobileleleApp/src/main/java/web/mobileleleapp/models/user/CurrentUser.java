package web.mobileleleapp.models.user;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import web.mobileleleapp.models.entities.enums.Role;

import java.util.HashSet;
import java.util.Set;

@Component
@SessionScope
public class CurrentUser {

    private boolean loggedIn;
    private String username;
    private String firstName;
    private String lastName;
    private Set<Role> roles = new HashSet<>();


    public CurrentUser() {
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public CurrentUser setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CurrentUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CurrentUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public CurrentUser addRole(Role role) {
        roles.add(role);
        return this;
    }

    public CurrentUser clearRoles() {
        roles.clear();
        return this;
    }

    public boolean isAdmin() {
        return roles.contains(Role.Admin);
    }

    public void clear() {
        setLoggedIn(false);
        setUsername(null);
        setFirstName(null);
        setLastName(null);
        clearRoles();
    }

}
