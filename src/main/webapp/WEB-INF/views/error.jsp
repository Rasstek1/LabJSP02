<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Erreur</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .error {
            color: red;
            margin: 20px;
        }
        .error h1 {
            font-size: 1.5em;
        }
        .error p {
            font-size: 1em;
            margin: 10px 0;
        }
    </style>
</head>
<body>
<h1>Attention, une erreur s’est produite dans la ressource demandée. Veuillez contacter le support technique.</h1>
<p>Status: ${requestScope['javax.servlet.error.status_code']}</p>
<p>Message: ${requestScope['javax.servlet.error.message']}</p>
<c:url var="accueilURL" value="/home/accueil"/>
<hr/>
<a href="/LabJSP02/accueil">Accueil">Allez à l'accueil</a>

</body>
</html>


