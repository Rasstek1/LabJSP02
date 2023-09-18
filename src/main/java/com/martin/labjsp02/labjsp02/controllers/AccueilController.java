package com.martin.labjsp02.labjsp02.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {

    @GetMapping("/accueil")
    public String accueil(Model model) {
        model.addAttribute("pageContent", "accueil");
        return "layout";
    }

    @GetMapping("/Accueil/contact")
    public String contact(Model model) {
        model.addAttribute("pageContent", "contact");
        return "layout";
    }
}
