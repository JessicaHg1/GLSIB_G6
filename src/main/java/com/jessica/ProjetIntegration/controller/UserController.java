package com.jessica.ProjetIntegration.controller;

import com.jessica.ProjetIntegration.model.User;
import com.jessica.ProjetIntegration.service.UserPrincipalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Users")
public class UserController {

    @Autowired
    private UserPrincipalDetailService userPrincipalDetailService;

    private PasswordEncoder passwordEncoder;

    public UserController(UserPrincipalDetailService userPrincipalDetailService, PasswordEncoder passwordEncoder) {
        this.userPrincipalDetailService = userPrincipalDetailService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/all")
    public String showAllUsers(Model model){
        model.addAttribute("users", userPrincipalDetailService.getList());
        return "users/listUser";
    }

    @GetMapping("/create")
    public String create(){
        return "users/addUser";
    }

    @PostMapping("/save")
    public String save(User user){
        user.setRole("UTILISATEUR");
        user.setPermission("");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userPrincipalDetailService.save(user);
        return "redirect:/Users/all";
    }
}
