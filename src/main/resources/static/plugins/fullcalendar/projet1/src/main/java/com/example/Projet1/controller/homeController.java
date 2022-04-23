package com.example.Projet1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
    @GetMapping("/exemple")
    public String Hello(){
        return "exemple";
    }
}