package com.martin.labjsp02.labjsp02.controllers;

import com.martin.labjsp02.labjsp02.models.Evaluation;
import com.martin.labjsp02.labjsp02.models.EvaluationDataContext;
import com.martin.labjsp02.labjsp02.models.EvaluationViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationDataContext evaluationDataContext;

    @GetMapping("/liste")
    public String liste(Model model) {
        model.addAttribute("evaluations", evaluationDataContext.getListeEvaluations());
        model.addAttribute("pageContent", "liste");
        return "layout";
    }

    @GetMapping("/ajouter")
    public String ajouter(Model model) {
        model.addAttribute("pageContent", "ajouter");
        model.addAttribute("evaluation", new EvaluationViewModel());

        return "layout";
    }

    @PostMapping("/ajouter")
    public String ajouter(@ModelAttribute EvaluationViewModel model) {
        Evaluation eval = model.Mapper();
        evaluationDataContext.Ajouter(eval);
        return "redirect:/Evaluation/liste";
    }

    @GetMapping("/supprimer/{numero}")
    public String supprimer(@PathVariable int numero) {
        evaluationDataContext.Supprimer(numero);
        return "redirect:/Evaluation/liste";
    }

    @GetMapping("/modifier/{numero}")
    public String modifier(@PathVariable int numero, Model model) {
        Evaluation eval = evaluationDataContext.rechercher(numero);
        EvaluationViewModel viewModel = eval.Mapper();
        model.addAttribute("evaluation", viewModel);
        model.addAttribute("pageContent", "modifier");
        return "layout";
    }

    @PostMapping("/modifier")
    public String modifier(@ModelAttribute EvaluationViewModel model) {
        Evaluation eval = model.Mapper();
        evaluationDataContext.Modifier(eval);
        return "redirect:/Evaluation/liste";
    }
}
