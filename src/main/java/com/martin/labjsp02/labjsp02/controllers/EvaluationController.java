package com.martin.labjsp02.labjsp02.controllers;

import com.martin.labjsp02.labjsp02.models.Evaluation;
import com.martin.labjsp02.labjsp02.models.EvaluationDataContext;
import com.martin.labjsp02.labjsp02.models.EvaluationViewModel;
import com.martin.labjsp02.labjsp02.service.FileStorageService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationDataContext evaluationDataContext;
    @Autowired
    private FileStorageService fileStorageService;

    @RequestMapping(value = "/liste", method = RequestMethod.GET)
    public String liste(Model model) {
        model.addAttribute("evaluations", evaluationDataContext.getListeEvaluations());
        model.addAttribute("pageContent", "liste");
        return "layout";
    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.GET)
    public String ajouter(Model model) {
        model.addAttribute("pageContent", "ajouter");
        model.addAttribute("evaluation", new EvaluationViewModel());
        return "layout";
    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public String ajouter(@ModelAttribute EvaluationViewModel model) {
        Evaluation eval = model.Mapper();
        evaluationDataContext.Ajouter(eval);
        return "redirect:/Evaluation/liste";
    }

    @RequestMapping(value = "/supprimer/{numero}", method = RequestMethod.GET)
    public String supprimer(@PathVariable int numero) {
        evaluationDataContext.Supprimer(numero);
        return "redirect:/Evaluation/liste";
    }

    @RequestMapping(value = "/modifier/{numero}", method = RequestMethod.GET)
    public String modifier(@PathVariable int numero, Model model, HttpServletRequest request) {
        Evaluation eval = evaluationDataContext.rechercher(numero);
        EvaluationViewModel viewModel = eval.Mapper(request);
        model.addAttribute("evaluation", viewModel);
        model.addAttribute("pageContent", "modifier");
        return "layout";
    }

    @RequestMapping(value = "/modifier", method = RequestMethod.POST)
    public String modifier(@ModelAttribute EvaluationViewModel model) {
        Evaluation eval = model.Mapper();
        evaluationDataContext.Modifier(eval);
        return "redirect:/Evaluation/liste";
    }

    /*DOIT CREER UN MODEL ALLER AVEC CECI POUR LE FORMULAIRE*/
   /* @ExceptionHandler(Exception.class)
    public ModelAndView errorHandller(Exception exception, HttpServletRequest request){
        ModelAndView mv = new ModelAndView("erreur");
// initialiser le model à envoyer à la vue erreur
        ErrorViewModel viewModel = new ErrorViewModel(request.getRequestURL().toString(), ex);
// envoyer le model à la vue erreur
        mv.addObject("model", viewModel );
        return mv;
    }*/

}




