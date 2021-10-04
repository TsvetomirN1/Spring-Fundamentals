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
    private String userName;
    private String firstName;
    private String lastName;
    private Set<Role> roles = new HashSet<>();

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public CurrentUser setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public CurrentUser setUserName(String userName) {
        this.userName = userName;
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

    public void clean() {
        setLoggedIn(false).
                setUserName(null).setFirstName(null).setLastName(null).
                clearRoles();
    }
}
