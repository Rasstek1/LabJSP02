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



    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire=commentaire;
    }


    public Calendar getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(Calendar dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
    }
    private static Date convertDate(String strDate) {
        if (strDate == null) {

            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            java.util.Date parseDate = dateFormat.parse(strDate);
            return  parseDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
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
        String strDateEvaluation = request.getParameter("dateEvaluation");

        Date dateEvaluation = Evaluation.convertDate(strDateEvaluation);

        Calendar dateEvaluation2 = Calendar.getInstance();
        dateEvaluation2.setTime(dateEvaluation);

        return evaluationViewModel;
    }

}








