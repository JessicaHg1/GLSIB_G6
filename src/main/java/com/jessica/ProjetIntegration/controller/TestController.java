package com.jessica.ProjetIntegration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/page")
    public String afficherHello(){
        return "test";
    }
}
