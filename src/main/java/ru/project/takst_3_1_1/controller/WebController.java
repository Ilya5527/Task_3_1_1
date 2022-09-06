package ru.project.takst_3_1_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.project.takst_3_1_1.entity.User;
import ru.project.takst_3_1_1.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/userList")
public class WebController {

    private final UserService service;

    public WebController(UserService userService) {
        this.service = userService;
    }


    @GetMapping()
    public String usersList(ModelMap modelMap) {

        List<User> userList = service.getAllUsers();
        modelMap.addAttribute("users", userList);

        return "userList";
    }

    @GetMapping("/addUser")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }


    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            if (bindingResult.hasErrors()) {
                return "addUser";
            }
        }
        service.add(user);
        return "redirect:userList";
    }

    @DeleteMapping("/{id}")
    public String getUser(@PathVariable("id") long id) {

        service.delete(id);

        return "redirect:/userList";
    }

    @GetMapping("/{id}/updateUser")
    public String update(@PathVariable("id") long id, ModelMap model) {
        User user = service.getUserById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateUser";
        }
        service.update(user);
        return "redirect:/userList";
    }
}
