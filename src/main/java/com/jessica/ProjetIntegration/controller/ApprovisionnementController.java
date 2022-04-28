package com.jessica.ProjetIntegration.controller;

import com.jessica.ProjetIntegration.model.Approvisionnement;
import com.jessica.ProjetIntegration.model.Categorie;
import com.jessica.ProjetIntegration.model.Produit;
import com.jessica.ProjetIntegration.service.ApprovisionnementService;
import com.jessica.ProjetIntegration.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/approvisionner")
public class ApprovisionnementController {

    @Autowired
    private ApprovisionnementService approvisionnementService;

    @GetMapping("/show")
    public String afficherAppro(Model model){
        model.addAttribute("listAppro", approvisionnementService.showAllAppro());
        System.out.println(approvisionnementService.showAllAppro());
        return "approvisionnement/showProvision";
    }

    @PostMapping("/save")
    public String saveAppro(Approvisionnement approvisionnement){
        approvisionnement.setDate_mv_stock(LocalDate.now());
        approvisionnementService.save(approvisionnement);
        return "redirect:/approvisionner/show";
    }

    @GetMapping("/edit/{id}")
    public String editFormProvision(@PathVariable("id") int id, Model model){
        model.addAttribute("uneProvision", approvisionnementService.selectOneProvision(id));
        return "approvisionnement/editAppro";
    }

    @PostMapping("/edit")
    public String updateCategorie(@ModelAttribute("approvisionnement") Approvisionnement approvisionnement){
        approvisionnementService.save(approvisionnement);
        return "redirect:/approvisionner/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteAppro(@PathVariable("id") int id){
        approvisionnementService.deleteProvision(id);
        return "redirect:/approvisionner/show";
    }
}
