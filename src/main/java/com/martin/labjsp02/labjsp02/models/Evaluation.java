package com.martin.labjsp02.labjsp02.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Evaluation {
    private int numero;
    private String nom;
    private String prenom;
    private String telephone;
    private String courriel;
    private char sexe;

    private String note;
    private Calendar dateEvaluation;

    private String commentaire;



    public Evaluation() {
    }

    public Evaluation(int numero, String nom, String prenom, String telephone, String courriel, char sexe, String note, Calendar dateEvaluation, String commentaire) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.courriel = courriel;
        this.sexe = sexe;
        this.note = note;
        this.dateEvaluation = dateEvaluation;
        this.commentaire = commentaire;

    }



    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom=nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom=prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone=telephone;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel=courriel;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe=sexe;
    }

    public String getNote() {
        return note;
    }

    public void setNote (String note) {
        this.note=note;
    }

    public Calendar getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(Calendar dateEvaluation) {
        this.dateEvaluation=dateEvaluation;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire=commentaire;
    }




    // Méthode Mapper pour convertir en EvaluationViewModel
    public EvaluationViewModel Mapper() {
        EvaluationViewModel evaluationViewModel = new EvaluationViewModel();

        evaluationViewModel.setNumero(this.numero);
        evaluationViewModel.setNom(this.nom);
        evaluationViewModel.setPrenom(this.prenom);
        evaluationViewModel.setTelephone(this.telephone);
        evaluationViewModel.setCourriel(this.courriel);
        evaluationViewModel.setSexe(this.sexe);
        evaluationViewModel.setNote(this.note);
        evaluationViewModel.setCommentaire(this.commentaire);

        // Conversion de Calendar à String pour dateEvaluation
        if(this.dateEvaluation != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            evaluationViewModel.setDateEvaluation(sdf.format(this.dateEvaluation.getTime()));

        }




        return evaluationViewModel;
    }


}
