package com.martin.labjsp02.labjsp02.models;

import jakarta.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    private String photoPath;



    public Evaluation() {
    }

    public Evaluation(int numero, String nom, String prenom, String telephone, String courriel, char sexe, String note, Calendar dateEvaluation, String commentaire, String photoPath) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.courriel = courriel;
        this.sexe = sexe;
        this.note = note;
        this.dateEvaluation = dateEvaluation;
        this.commentaire = commentaire;
        this.photoPath = photoPath;

    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", sexe='" + sexe + '\'' +
                // ... autres champs ...
                ", photoPath='" + photoPath + '\'' +
                '}';
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
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Calendar getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(Calendar dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
    }

    private String convertCalendarToString(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (calendar != null) {
            return sdf.format(calendar.getTime());
        } else {
            return null;
        }

    }

    // Méthode Mapper pour convertir en EvaluationViewModel pour l'affichage
    public EvaluationViewModel Mapper(HttpServletRequest request) {
        EvaluationViewModel evaluationViewModel = new EvaluationViewModel();

        evaluationViewModel.setNumero(this.numero);
        evaluationViewModel.setNom(this.nom);
        evaluationViewModel.setPrenom(this.prenom);
        evaluationViewModel.setTelephone(this.telephone);
        evaluationViewModel.setCourriel(this.courriel);
        evaluationViewModel.setSexe(this.sexe);
        evaluationViewModel.setNote(this.note);
        evaluationViewModel.setCommentaire(this.commentaire);
        evaluationViewModel.setDateEvaluation(this.convertCalendarToString(this.dateEvaluation));
        evaluationViewModel.setPhotoPath(this.photoPath);


        return evaluationViewModel;
    }

}








