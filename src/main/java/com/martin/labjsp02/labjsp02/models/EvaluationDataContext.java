package com.martin.labjsp02.labjsp02.models;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Service
public class EvaluationDataContext implements IEvaluationContext {

    private static List<Evaluation> listeEvaluations = new ArrayList<>();

    public List<EvaluationViewModel> getListeEvaluations() {
        List<EvaluationViewModel> evaluationViewModels = new ArrayList<>();

        for (Evaluation evaluation : listeEvaluations) {
            EvaluationViewModel viewModel = new EvaluationViewModel();
            viewModel.setNumero(evaluation.getNumero());
            viewModel.setNom(evaluation.getNom());
            viewModel.setPrenom(evaluation.getPrenom());
            viewModel.setTelephone(evaluation.getTelephone());
            viewModel.setCourriel(evaluation.getCourriel());
            viewModel.setSexe(evaluation.getSexe());
            viewModel.setNote(evaluation.getNote());
            viewModel.setCommentaire(evaluation.getCommentaire());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if(evaluation.getDateEvaluation() != null) {
                viewModel.setDateEvaluation(sdf.format(evaluation.getDateEvaluation().getTime()));
            }
            evaluationViewModels.add(viewModel);
        }

        return evaluationViewModels;
    }



    public Evaluation rechercher(int numero) {
        for (Evaluation evaluation : listeEvaluations) {
            if (evaluation.getNumero() == numero) {
                return evaluation;
            }
        }
        return null;
    }

    @Override
    public void Ajouter(Evaluation element) {
        listeEvaluations.add(element);
    }

//Verification du numero entrer et le change pour le prochain numero disponible
    public int getUniqueNumero() {
        Set<Integer> existingNumbers = listeEvaluations.stream()
                .map(Evaluation::getNumero)
                .collect(Collectors.toSet());

        int proposedNumero = 1;
        while (existingNumbers.contains(proposedNumero)) {
            proposedNumero++;
        }
        return proposedNumero;
    }


    @Override
    public void Supprimer(int numero) {
        listeEvaluations.removeIf(evaluation -> evaluation.getNumero() == numero);
    }

    @Override
    public void Modifier(Evaluation element) {
        for (int i = 0; i < listeEvaluations.size(); i++) {
            if (listeEvaluations.get(i).getNumero() == element.getNumero()) {
                listeEvaluations.set(i, element);
                break;
            }
        }
    }
}