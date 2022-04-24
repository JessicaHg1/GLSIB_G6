package com.jessica.ProjetIntegration.controller;

import com.jessica.ProjetIntegration.model.Categorie;
import com.jessica.ProjetIntegration.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    //liste complète des catégories
    @GetMapping("/afficher")
    public String showListCategorie(Model model){
        model.addAttribute("listCategorie", categorieService.showAllCattegorie());
        return "categorie/showCategorie";
    }

    @GetMapping("/formCategorie")
    public String formCategorie(){

        return "categorie/formCategorie";
    }

    @PostMapping("/save")
    public String saveCategorie(Categorie categorie){
        categorieService.save(categorie);
        return "redirect:/categories/afficher";
    }

    @GetMapping("/edit/{id}")
    public String editFormCategorie(@PathVariable("id") int id, Model model){
        model.addAttribute("uneCategorie", categorieService.selectOneCategorie(id));
        return "categorie/formEditCategorie";
    }

    @PostMapping("/edit")
    public String updateCategorie(@ModelAttribute("categorie") Categorie categorie){
        categorieService.save(categorie);
        return "redirect:/categories/afficher";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategorie(@PathVariable("id") int id){
        categorieService.deleteCategorie(id);
        return "redirect:/categories/afficher";
    }
}
