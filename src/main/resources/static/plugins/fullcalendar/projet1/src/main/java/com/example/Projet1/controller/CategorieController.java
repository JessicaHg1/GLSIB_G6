package com.example.Projet1.controller;


import com.example.Projet1.models.Categorie;
import com.example.Projet1.models.Produit;
import com.example.Projet1.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/afficher")
    public String ShowCategorie(Model model)
    {
        model.addAttribute("categorie",categorieService.showCategorie());
        return "categorie/ShowCategorie";
    }

    @GetMapping("/form")
    public  String formulaire()
    {
        return "categorie/SaveCategorie";
    }

    @PostMapping("/save")
    public  String save(Categorie categorie)
    {
        categorieService.saveCategorie(categorie);
        return "redirect:/categorie/afficher";
    }


    @PostMapping("/edit")
    public String updateCategorie(@ModelAttribute("categorie") Categorie categorie){
        categorieService.saveCategorie(categorie);
        return "redirect:/categorie/afficher";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategorie(@PathVariable("id") int id){
        categorieService.deleteCategorie(id);
        return "redirect:/categorie/afficher";
    }



}
