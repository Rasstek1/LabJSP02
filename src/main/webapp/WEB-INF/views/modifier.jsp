<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier évaluation</title>
</head>
<body>
<h2>Modifier évaluation</h2>
<form action="<c:url value='/Evaluation/modifier' />" method="POST">
    <input type="hidden" name="numero" value="${evaluation.numero}" />
    <div>
        <label>Nom :</label>
        <input type="text" name="nom" value="${evaluation.nom}" />
    </div>
    <div>
        <label>Prénom :</label>
        <input type="text" name="prenom" value="${evaluation.prenom}" />
    </div>
    <div>
        <label>Téléphone :</label>
        <input type="text" name="telephone" value="${evaluation.telephone}" />
    </div>
    <div>
        <label>Courriel :</label>
        <input type="email" name="courriel" value="${evaluation.courriel}" />
    </div>
    <div>
        <label>Sexe :</label>
        <input type="text" name="sexe" value="${evaluation.sexe}" />
    </div>
    <div>
        <label>Note :</label>
        <input type="text" name="note" value="${evaluation.note}" />
    </div>
    <div>
        <label>Date d'évaluation :</label>
        <input type="date" name="dateEvaluation" value="${evaluation.dateEvaluation}" />
    </div>
    <div>
        <label>Commentaire :</label>
        <textarea name="commentaire">${evaluation.commentaire}</textarea>
    </div>
    <button type="submit">Modifier</button>
</form>
</body>
</html>
