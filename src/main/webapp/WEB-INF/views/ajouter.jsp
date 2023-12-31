<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <h3>Ajouter une évaluation</h3>
    <div class="col-12 col-md-6 col-lg-4 mx-auto border  border-white p-4 boite-blurry">
        <form action="${pageContext.request.contextPath}/Evaluation/ajouter" method="POST" action="src/main/resources/static/uploads/" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="numero" class="form-label">Numéro</label>
                <input type="text" class="form-control" id="numero" name="numero" required>
            </div>
            <div class="mb-3">
                <label for="nom" class="form-label">Nom</label>
                <input type="text" class="form-control" id="nom" name="nom" required>
            </div>
            <div class="mb-3">
                <label for="prenom" class="form-label">Prénom</label>
                <input type="text" class="form-control" id="prenom" name="prenom" required>
            </div>
            <div class="mb-3">
                <label for="telephone" class="form-label">Téléphone</label>
                <input type="text" class="form-control" id="telephone" name="telephone" required>
            </div>
            <div class="mb-3">
                <label for="courriel" class="form-label">Courriel</label>
                <input type="email" class="form-control" id="courriel" name="courriel" required>
            </div>
            <div class="mb-3">
                <label for="dateEvaluation" class="form-label">Date d’évaluation</label>
                <input type="date" class="form-control" id="dateEvaluation" name="dateEvaluation">
            </div>
            <div class="mb-3">
                <label class="form-label">Sexe</label>
                <div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="sexe" id="masculin" value="m">
                        <label class="form-check-label" for="masculin" style="color:white;">Masculin</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="sexe" id="feminin" value="f">
                        <label class="form-check-label" for="feminin" style="color:white;">Féminin</label>
                    </div>
                </div>
            </div>
            <div class="mb-3">
                <label for="note" class="form-label">Note</label>
                <select class="form-select" id="note" name="note">
                    <option value="Tres bien">Très bien</option>
                    <option value="Bien">Bien</option>
                    <option value="Moyen">Moyen</option>
                    <option value="Mediocre">Médiocre</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="commentaire" class="form-label">Commentaires</label>
                <textarea class="form-control" id="commentaire" name="commentaire" required></textarea>
            </div>
            <div class="pb-3 text-white">
                <input type="file" name="photo" id="photo"/>
            </div>

            <button type="submit" class="btn btn-primary">Envoyer</button>
            <button type="reset" class="btn btn-secondary">Annuler</button>
        </form>
    </div>
</div>