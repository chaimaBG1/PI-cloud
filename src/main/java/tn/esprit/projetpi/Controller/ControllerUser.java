package tn.esprit.projetpi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.projetpi.Entities.User;
import tn.esprit.projetpi.Services.UserService;

@RestController
@RequestMapping("//")
public class ControllerUser {
    UserService userService;
    @GetMapping("/getUserById/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }
}
