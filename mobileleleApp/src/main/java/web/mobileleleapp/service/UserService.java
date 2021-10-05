package web.mobileleleapp.service;

import web.mobileleleapp.models.service.UserLoginServiceModel;
import web.mobileleleapp.models.service.UserRegisterServiceModel;

public interface UserService {

    void initializeUserAndRoles();

    boolean login(UserLoginServiceModel userLoginServiceModel);

    void register(UserRegisterServiceModel userRegisterServiceModel);

    void logoutUser();

    boolean isUserNameFree(String username);
}
