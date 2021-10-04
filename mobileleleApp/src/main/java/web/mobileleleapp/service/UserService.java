package web.mobileleleapp.service;

import web.mobileleleapp.models.service.UserLoginServiceModel;

public interface UserService {

    void initializeUserAndRoles();

    boolean login(UserLoginServiceModel loginServiceModel);

    void logoutUser();
}
