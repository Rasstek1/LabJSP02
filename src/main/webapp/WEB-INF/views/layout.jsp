<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Mon site</title>
    <!-- Inclure Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<header>
    <!-- Barre de navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Logo</a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/LabJSP02/accueil">Accueil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/LabJSP02/Evaluation/ajouter">Ajouter évaluation</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/LabJSP02/Evaluation/liste">Liste évaluations</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/LabJSP02/Accueil/contact">Nous contacter</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>


<!-- Corps de la page -->
<div class="container">
    <jsp:include page="${pageContent}.jsp" />
</div>

<!-- Pied de page -->
<footer class="text-center py-4">
    <p>© 2023 Mon site</p>
</footer>

<!-- Inclure Bootstrap JS et Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
