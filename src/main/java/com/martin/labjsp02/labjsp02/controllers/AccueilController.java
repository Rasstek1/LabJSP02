package com.martin.labjsp02.labjsp02.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {

    /**
     * Méthode pour afficher la page d'accueil
     * @param model
     * @return
     */
    @GetMapping("/accueil")
    public String accueil(Model model) {//L'objet Model est utilisé pour passer des attributs (data) de la méthode du contrôleur à la vue (JSP)
        model.addAttribute("pageContent", "accueil");// Signifie que dans le fichier JSP, on pourra accéder à cet attribut avec ${pageContent} et cela affichera la chaîne "accueil"
        return "layout";
    }

    /**
     * Méthode pour afficher la page contact
     * @param model
     * @return
     */
    @GetMapping("/Accueil/contact")
    public String contact(Model model) {
        model.addAttribute("pageContent", "contact");
        return "layout";
    }
}
