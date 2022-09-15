package com.example.pp311.pp311.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.pp311.pp311.model.User;
import com.example.pp311.pp311.service.UserService;

@Controller
@RequestMapping("/users")
public class UserManageControllerImpl {

    private final UserService userService;

    public UserManageControllerImpl(UserService userService) {
        this.userService = userService;
    }

    // переход
    @GetMapping("/create")
    public String create(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "view/user_manage";
    }

    // переход
    @GetMapping("/update/{id}")
    public String preUpdate(ModelMap modelMap, @PathVariable("id") Long id) {
        modelMap.addAttribute("user", userService.findOne(id));
        return "view/user_manage";
    }

    // сохранение
    @PostMapping("/create")
    public String create(User user) {
        userService.save(user);
        return "redirect:/index";
    }

    // обновление
    @PostMapping("/update")
    public String update(User user) {
        userService.save(user);
        return "redirect:/index";
    }

    // удаление
    @PostMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        userService.remove(id);
        return "redirect:/index";
    }
}
