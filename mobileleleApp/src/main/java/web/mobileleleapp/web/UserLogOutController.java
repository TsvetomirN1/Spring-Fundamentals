package web.mobileleleapp.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import web.mobileleleapp.service.UserService;

@Controller
public class UserLogOutController {

    private final UserService userService;

    public UserLogOutController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/logout")
    public String logout() {
        userService.logoutUser();
        return "redirect:/";
    }
}
