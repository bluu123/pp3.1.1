package com.example.pp311.pp311.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.pp311.pp311.service.UserService;

@Controller
public class IndexController {

    private final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "/index"})
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("userList", userService.findAll());
        return "view/index";
    }
}
