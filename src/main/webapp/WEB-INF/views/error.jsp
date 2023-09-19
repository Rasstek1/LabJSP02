<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Attention, une erreur s’est produite dans la ressource demandée. Veuillez contacter le support technique. </h1>
<h2>Message : ${message}</h2>
<h2>Date :${timestamp}</h2>
<h2>Code : ${status}</h2>
<c:url var="accueilURL" value="/home/accueil"/>
<hr/> <a href="${accueilURL}"> allez à l'accueil</a>

</body>
</html>

