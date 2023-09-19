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

    /**
     * L'annotation @Autowired permet d'injecter une dépendance dans une classe.
     */
    @Autowired
    private EvaluationDataContext evaluationDataContext;
    @Autowired
    private FileStorageService fileStorageService;// Injecter le service de stockage de fichiers pour les photos.*Pas implémenté dans cet exemple

    /**
     * L'annotation @GetMapping indique que cette méthode doit gérer les requêtes GET à l'URL "/liste"
     * @param model
     * @return
     */
    @GetMapping("/liste")//indique que cette méthode doit gérer les requêtes GET à l'URL "/liste"
    public String liste(Model model) {//Le paramètre model est utilisé pour passer des données du contrôleur à la vue.
        model.addAttribute("evaluations", evaluationDataContext.getListeEvaluations());// La valeur de cet attribut est obtenue en appelant la méthode getListeEvaluations() sur un objet evaluationDataContext
        model.addAttribute("pageContent", "liste");// un autre attribut au model avec la clé "pageContent" et la valeur "liste". Utilisé pour déterminer quel fragment de contenu doit être affiché dans la vue
        return "layout";
    }

    /**
     * L'annotation @GetMapping indique que cette méthode doit gérer les requêtes GET à l'URL "/ajouter"
     * @param model
     * @return
     */
    @GetMapping("/ajouter")
    public String ajouter(Model model) {
        model.addAttribute("pageContent", "ajouter");
        model.addAttribute("evaluation", new EvaluationViewModel());

        return "layout";
    }

    /**
     * L'annotation @PostMapping indique que cette méthode doit gérer les requêtes POST à l'URL "/ajouter"
     * @param model
     * @return
     */
    @PostMapping("/ajouter")
    public String ajouter(@ModelAttribute EvaluationViewModel model) {//L'annotation @ModelAttribute indique que le paramètre model doit être lié à un objet EvaluationViewModel
        Evaluation eval = model.Mapper();//Appel de la méthode Mapper() sur l'objet model pour mapper les données de l'objet EvaluationViewModel vers un objet Evaluation
        evaluationDataContext.Ajouter(eval);
        return "redirect:/Evaluation/liste";
    }

    /**
     * L'annotation @GetMapping indique que cette méthode doit gérer les requêtes GET à l'URL "/supprimer/{numero}"
     * @param numero
     * @return
     */
    @GetMapping("/supprimer/{numero}")
    public String supprimer(@PathVariable int numero) {//L'annotation @PathVariable indique que la valeur de la variable d'URL {numero} doit être assignée au paramètre numero
        evaluationDataContext.Supprimer(numero);//Appel de la méthode Supprimer() sur l'objet evaluationDataContext pour supprimer l'évaluation avec le numéro spécifié
        return "redirect:/Evaluation/liste";
    }

    /**
     * L'annotation @GetMapping indique que cette méthode doit gérer les requêtes GET à l'URL "/modifier/{numero}"
     * @param numero
     * @param model
     * @return
     */
    @GetMapping("/modifier/{numero}")
    public String modifier(@PathVariable int numero, Model model) {
        Evaluation eval = evaluationDataContext.rechercher(numero);
        EvaluationViewModel viewModel = eval.Mapper();//Appel de la méthode Mapper() sur l'objet eval pour mapper les données de l'objet Evaluation vers un objet EvaluationViewModel
        model.addAttribute("evaluation", viewModel);
        model.addAttribute("pageContent", "modifier");
        return "layout";
    }

    /**
     * L'annotation @PostMapping indique que cette méthode doit gérer les requêtes POST à l'URL "/modifier"
     * @param model
     * @return
     */
    @PostMapping("/modifier")
    public String modifier(@ModelAttribute EvaluationViewModel model) {
        Evaluation eval = model.Mapper();
        evaluationDataContext.Modifier(eval);
        return "redirect:/Evaluation/liste";
    }





}
