package com.martin.labjsp02.labjsp02.models;

import jakarta.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EvaluationViewModel {

    private int numero;
    private String nom;

    private String prenom;
    private String telephone;
    private String courriel;
    private char sexe;
    private String note;
    private String dateEvaluation;
    private String commentaire;



    public EvaluationViewModel() {
    }

    public EvaluationViewModel(int numero, String nom, String prenom, String telephone, String courriel, char sexe, String note, String dateEvaluation, String commentaire) {
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
        this.sexe = sexe;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note=note;
    }

    public String getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(String dateEvaluation) {
        this.dateEvaluation=dateEvaluation;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire=commentaire;
    }



    // Méthode pour convertir une chaîne de caractères en Calendar
    private Calendar convertirDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        if(dateStr == null || dateStr.trim().isEmpty()) {
            return null; // Retourne null si dateStr est null ou vide
        }

        try {
            Date date = dateFormat.parse(dateStr);
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace(); // Gérer l'exception en cas d'erreur de conversion
        }

        return calendar;
    }

    public Date getDateEvaluationAsDate() {
        if (this.dateEvaluation != null && !this.dateEvaluation.trim().isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return dateFormat.parse(this.dateEvaluation);
            } catch (ParseException e) {
                e.printStackTrace(); // Gérer l'exception en cas d'erreur de conversion
            }
        }
        return null;
    }



    public Evaluation Mapper() {
        Evaluation evaluation = new Evaluation();
        evaluation.setNumero(this.numero);
        evaluation.setNom(this.nom);
        evaluation.setPrenom(this.prenom);
        evaluation.setTelephone(this.telephone);
        evaluation.setCourriel(this.courriel);
        evaluation.setSexe(this.sexe);
        evaluation.setNote (this.note);
        evaluation.setCommentaire(this.commentaire);

        // Vous devez convertir la date ici à partir d'une chaîne
        evaluation.setDateEvaluation(convertirDate(this.dateEvaluation));

        return evaluation;
    }



}
