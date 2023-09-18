<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des évaluations</title>
    <!-- Inclusion du CSS de Bootstrap via CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2 class="my-4">Liste des évaluations</h2>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Numéro</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Téléphone</th>
            <th>Courriel</th>
            <th>Sexe</th>
            <th>Note</th>
            <th>Date d'évaluation</th>
            <th>Commentaire</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${not empty evaluations}">
                <c:forEach var="eval" items="${evaluations}">
                    <tr>
                        <td>${eval.numero}</td>
                        <td>${eval.nom}</td>
                        <td>${eval.prenom}</td>
                        <td>${eval.telephone}</td>
                        <td>${eval.courriel}</td>
                        <td>${eval.sexe}</td>
                        <td>${eval.note}</td>
                        <td><fmt:formatDate value="${eval.dateEvaluation}" pattern="yyyy-MM-dd" /></td>
                        <td>${eval.commentaire}</td>
                        <td>
                            <a href="<c:url value='/Evaluation/modifier/${eval.numero}' />" class="btn btn-warning">Modifier</a>
                            <a href="<c:url value='/Evaluation/supprimer/${eval.numero}' />" class="btn btn-danger">Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="10" class="text-center">Aucune évaluation disponible.</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
    <a href="<c:url value='/Evaluation/ajouter' />" class="btn btn-success">Ajouter une nouvelle évaluation</a>
</div>
<!-- Inclusion du JS de Bootstrap via CDN -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
