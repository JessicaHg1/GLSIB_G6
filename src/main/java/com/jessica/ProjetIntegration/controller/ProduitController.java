package com.jessica.ProjetIntegration.controller;

import com.jessica.ProjetIntegration.model.Produit;
import com.jessica.ProjetIntegration.service.ApprovisionnementService;
import com.jessica.ProjetIntegration.service.CategorieService;
import com.jessica.ProjetIntegration.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private ApprovisionnementService approvisionnementService;

    //liste complète des produits
    @GetMapping("/show")
    public String afficherProduit(Model model){
        model.addAttribute("listProduits", produitService.showAllProduit());
        return "produits/showProducts";
    }

    //Afficher formulaire d'enregistrement de produits
    @GetMapping("/create")
    public String afficherFormulaire(Model model){
        model.addAttribute("listCategorie", categorieService.showAllCattegorie());
        return "produits/saisieProduit";
    }

    //Enregistrer des produits
    @PostMapping("/save")
    public String save(Produit produit){
        produit.setQte_stock(0);
        produit.setDate_creation(LocalDate.now());
        produitService.saveProduit((produit));
        return "redirect:/produit/show";
    }

    //Afficher formulaire de modification de produit
    @GetMapping("/edit/{id}")
    public String formEditProduit(@PathVariable("id") int id, Model model){
        model.addAttribute("unProduit", produitService.selectedProduit(id));
        model.addAttribute("listCategorie", categorieService.showAllCattegorie());
        return "produits/editProduit";
    }

    //Modifier un produit
    @PostMapping("/edit")
    public String editProduit(@ModelAttribute("produit")Produit produit){
        produitService.saveProduit(produit);
        return "redirect:/produit/show";
    }

    //Supprimer un produit
    @GetMapping("/delete/{id}")
    public String deleProduit(@PathVariable("id") int id){
        produitService.deletedProduit(id);
        return "redirect:/produit/show";
    }

    //Afficher formulaire d'approvisionnement
    @GetMapping("/approv/{id}")
    public String approvisionnerProduit(@PathVariable("id") int id, Model model){
        model.addAttribute("unProduit", produitService.selectedProduit(id));
        return "produits/formApprovisionnement";
    }

    //Approvisionner un produit
    @PostMapping("/approv")
    public String provisionProduit(@ModelAttribute("produit")Produit produit){
        produitService.saveProduit(produit);
        return "redirect:/produit/show";
    }
}
