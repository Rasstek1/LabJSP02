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

    private String photoPath;


    public EvaluationViewModel() {
    }

    public EvaluationViewModel(int numero, String nom, String prenom, String telephone, String courriel, char sexe, String note, String dateEvaluation, String commentaire, String photoPath) {
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


    public String getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(String dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
    }

    public Calendar convertStringToCalendar() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parsedDate = sdf.parse(dateEvaluation);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parsedDate);
            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
        }
          return null;
    }

//mapper configurer pour convertir en Evaluation (model)
        public Evaluation Mapper () {
            Evaluation evaluation = new Evaluation();
            evaluation.setNumero(this.numero);
            evaluation.setNom(this.nom);
            evaluation.setPrenom(this.prenom);
            evaluation.setTelephone(this.telephone);
            evaluation.setCourriel(this.courriel);
            evaluation.setSexe(this.sexe);
            evaluation.setNote(this.note);
            evaluation.setCommentaire(this.commentaire);
            evaluation.setPhotoPath(this.photoPath);

            evaluation.setDateEvaluation(this.convertStringToCalendar());

            return evaluation;
        }


    }
