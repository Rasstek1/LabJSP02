<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des évaluations</title>
    <!-- Inclusion du CSS de Bootstrap via CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .boite-blurry {
            border: 1px solid white;
            backdrop-filter: blur(10px);
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="my-4">Liste des évaluations</h2>
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <c:choose>
            <c:when test="${not empty evaluations}">
                <c:forEach var="eval" items="${evaluations}">
                    <div class="col">
                        <div class="boite-blurry">

                            <img src="${pageContext.request.contextPath}/uploads/${eval.photoPath}" alt="Photo de profil" class="img-profil" />






                            <!--<img src="${pageContext.request.contextPath}/img/${eval.sexe.toString() == 'm' ? 'men.png' : 'girl.png'}" alt="Photo du profil" class="logo-img"/>-->
                            <div class="card-body">
                                <h4 class="card-title">${eval.prenom} ${eval.nom}</h4>
                                <p class="card-text">
                                    <strong>Numéro :</strong> ${eval.numero} <br>
                                    <strong>Téléphone :</strong> ${eval.telephone} <br>
                                    <strong>Courriel :</strong> ${eval.courriel} <br>
                                    <strong>Sexe :</strong> ${eval.sexe} <br>
                                    <strong>Note :</strong> ${eval.note} <br>
                                    <strong>Commentaire :</strong> ${eval.commentaire} <br>
                                    <strong>Date d'évaluation :</strong>
                                    <c:choose>
                                        <c:when test="${not empty eval.dateEvaluation}">
                                            ${eval.dateEvaluation}
                                        </c:when>
                                        <c:otherwise>
                                            Non spécifié
                                        </c:otherwise>
                                    </c:choose>
                                </p>
                                <a href="<c:url value='/Evaluation/modifier/${eval.numero}' />" class="btn btn-warning">Modifier</a>
                                <a href="<c:url value='/Evaluation/supprimer/${eval.numero}' />" class="btn btn-danger">Supprimer</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <div class="col">
                    <div class="boite-blurry">
                        <div class="card-body">
                            <p class="card-text text-center">Aucune évaluation disponible.</p>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="my-4">
        <a href="<c:url value='/Evaluation/ajouter' />" class="btn btn-success">Ajouter une nouvelle évaluation</a>
    </div>
</div>
<!-- Inclusion du JS de Bootstrap via CDN -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


<!--c:choose: C'est utilisé pour réaliser un choix entre plusieurs blocs de code. Il fonctionne en collaboration avec c:when et c:otherwise -->
<!--c:when: Définissez une condition qui, si elle est vraie, exécute le bloc de code à l'intérieur de la balise c:when. Il est utilisé à l'intérieur d'un bloc c:choose.-->
<!--c:otherwise: Définissez un bloc de code qui sera exécuté si aucune des conditions c:when à l'intérieur du c:choose n'est vraie-->
<!--c: forEach permet de faire des boucles-->
<!--c: if permet de faire des conditions-->
<!--c: url permet de faire des liens-->

<!--fmt: formatDate permet de formater la date-->


