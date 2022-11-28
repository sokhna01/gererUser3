<%@include file="includes/header.jsp" %>
<%@include file="includes/footer.jsp" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
<link rel="stylesheet" href="<c:url value='/css/design.css'/>">
</head>--%>
<body id="login-body"> 
<div class="login-form">
	<h1>Connexion</h1>
	<c:if test="${connexionFailed == true}">
	<p class="errorMessage">Login et/ou mot de passe incorrect</p>
	</c:if>
	<br/>
	<form  method="post">
			<label>Login</label>
			<input type="text" name="login" value="${login}"> <br><br><br>
			<label>Password</label>
			<input type="password" name="password"> <br><br>
			<button type="submit" value="Soumettre">Se Conneter</button>
	</form>
	</div>
</body>
</html>