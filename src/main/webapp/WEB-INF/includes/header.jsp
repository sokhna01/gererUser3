<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/css/design.css'/>">
<script src="<c:url value='/js/script.css'/>"></script>

<title>Liste des utilisateurs</title>
</head>

<body>
	<div id="entete1">Gestion des utilisateurs</div>
	<div class = "container">
		<nav>
		<ul>
			<c:choose>
			  <c:when test="${ sessionScope.isConnected }">
			<li><a href="<c:url value='/list'/>">Lister</a></li>
			<li><a href="<c:url value='/add'/>">Ajouter</a></li>
			<li><a href="<c:url value='/logout'/>">Déconnexion</a></li>
			  </c:when>
			<c:otherwise>
				<li><a href="<c:url value='/login'/>">Connexion</a></li>
			</c:otherwise>
			</c:choose>
		</ul>
		</nav>
	</div>
</body>
</html>
