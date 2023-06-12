package kr.codesqaud.cafe.controller;

import kr.codesqaud.cafe.domain.User;
import kr.codesqaud.cafe.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public String joinUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String getUserList(Model model) {
        model.addAttribute("users", userService.getUserList());
        return "/user/list";
    }
    @GetMapping("/users/{id}")
    public String userProfile(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/profile";
    }

    @GetMapping("/users/{id}/update")
    public String userProfileUpdate(@PathVariable Long id){
        User user = userService.getUserById(id);
        return "user/updateForm";
    }

    @PutMapping("/users/{id}/update")
    public String userPut(@PathVariable Long id, User user){
        userService.update(user);
        return "redirect:/users";
    }
}
