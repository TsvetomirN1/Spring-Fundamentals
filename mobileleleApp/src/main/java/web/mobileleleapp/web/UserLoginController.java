package web.mobileleleapp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.mobileleleapp.models.binding.UserLoginBindingModel;
import web.mobileleleapp.models.service.UserLoginServiceModel;
import web.mobileleleapp.service.UserService;


@Controller
public class UserLoginController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginBindingModel userLoginBindingModel) {

        // Delegate the logic to the service layer
        boolean loginSuccessful = userService.
                login(new UserLoginServiceModel().
                        setUsername(userLoginBindingModel.getUsername()).
                        setRawPassword(userLoginBindingModel.getPassword()));

        LOGGER.info("User tried to login. User with name {} tried to login. Success = {}?",
                userLoginBindingModel.getUsername(),
                loginSuccessful);

        return "redirect:/users/login";
    }

    @GetMapping("/users/logout")
    public String logout() {
        userService.logoutUser();
        return "index";
    }
}
