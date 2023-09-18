<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
    <h2>Contactez-nous</h2>
    <p>Adresse : 123 rue ABC</p>
    <p>Téléphone : 123-456-7890</p>
    <p>Email : info@votresite.com</p>

    <form action="/envoyerEmail" method="POST">
        <div class="mb-3">
            <label for="email" class="form-label">Votre Email</label>
            <input type="email" class="form-control" id="email" name="email">
        </div>
        <div class="mb-3">
            <label for="message" class="form-label">Votre message</label>
            <textarea class="form-control" id="message" name="message"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Envoyer</button>
    </form>
</div>
