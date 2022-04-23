package com.example.Projet1.controller;


import com.example.Projet1.models.Categorie;
import com.example.Projet1.models.Produit;
import com.example.Projet1.service.CategorieService;
import com.example.Projet1.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.modelmbean.ModelMBeanInfoSupport;
import java.time.LocalDate;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    ProduitService produitService;
    @Autowired
    CategorieService categorieService;

    @GetMapping("/afficher")
    public String displayProduct(Model model)
    {
        model.addAttribute("produits",produitService.showProduits());
        return "produits/ShowProduct";
    }

    @GetMapping("/form")
    public  String renseign(Model model)
    {
        model.addAttribute("UneCategorie", categorieService.showCategorie());
        return "produits/SaveProduit";
    }

    @PostMapping("/save")
    public  String save(@ModelAttribute("produit") Produit produit, @ModelAttribute("categorie")Categorie categorie)
    {
        produit.setDateCreation(LocalDate.now());
        produit.setQtStock(0);
        produit.setCategorie(categorie);
        produitService.saveProduit(produit);
        return "redirect:/produits/afficher";
    }

    @GetMapping("/edit/{id}")
    public String FormEdit(@PathVariable("id") int id ,Model model){
        model.addAttribute("UnProduit", produitService.showOneProduit(id));
        model.addAttribute("UneCategorie", categorieService.showCategorie());
        return "produits/formUpdate";
    }

    @PostMapping("/edit")
    public String updateProduit(@ModelAttribute("produit") Produit produit){
        produitService.saveProduit(produit);
        return "redirect:/produits/afficher";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduit(@PathVariable("id") int id){
        produitService.deleteProduit(id);
        return "redirect:/produits/afficher";
    }

}
