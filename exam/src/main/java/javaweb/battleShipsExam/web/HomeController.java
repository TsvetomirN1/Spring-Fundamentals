package javaweb.battleShipsExam.web;


import javaweb.battleShipsExam.current.CurrentUser;
import javaweb.battleShipsExam.model.binding.BattleBindingModel;
import javaweb.battleShipsExam.model.view.ShipViewModel;
import javaweb.battleShipsExam.service.ShipService;
import javaweb.battleShipsExam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final ShipService shipService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, ShipService shipService, UserService userService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }
        model.addAttribute("allShips", shipService.findAll());

        model.addAttribute("loggedUserShips",
                shipService
                        .findByUser(currentUser.getId())
                        .stream()
                        .map(ShipViewModel::getName)
                        .collect(Collectors.toList()));

        model.addAttribute("notLoggedUserShips",
                shipService
                        .findByUserNot(currentUser.getId())
                        .stream()
                        .map(ShipViewModel::getName)
                        .collect(Collectors.toList()));

        List<String> names = shipService
                .findAll()
                .stream()
                .map(ShipViewModel::getName)
                .collect(Collectors.toList());

        model.addAttribute("names", names);
        model.addAttribute("name1", "");
        model.addAttribute("name2", "");

        return "home";
    }

    @ModelAttribute
    public BattleBindingModel battleBindingModel() {
        return new BattleBindingModel();
    }

    @GetMapping("fire/{name1}/{name2}")
    public String fire(@PathVariable String name1,
                       @PathVariable String name2,
                       Model model) {
        model.addAttribute("name1");
        model.addAttribute("name2");
        shipService.fire(name1, name2);
        return "redirect:/";
    }

}
