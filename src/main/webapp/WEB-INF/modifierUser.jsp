<%@include file="includes/header.jsp" %>
<%@include file="includes/footer.jsp" %> 

<%@page import="beans.User"%>

	<div class="registration-form">
		<h2 class="entete">Modification </h2>
        <% User utilisateur = (User) request.getAttribute("utilisateur"); %>
		<form method="post">

				<label for="nom">Nom</label><br>
				<input class="simpleInput" type="text" name="nom" id="nom" value="<%=utilisateur.getNom()%>"><br>
				
				
				<label for="prenom">Prénom</label><br>
				<input class="simpleInput" type="text" name="prenom" id="prenom" value="<%=utilisateur.getPrenom()%>"><br>
				
				
				<label for="login">Login</label><br>
				<input class="simpleInput" type="text" name="login" id="login" value="<%=utilisateur.getLogin()%>"><br>
				
				
				<label for="password">Password</label><br>
	 			<input  class="simpleInput" type="text" name="password" id="password" value="<%=utilisateur.getPassword()%>"><br><br>
			
				<input type="submit" value="Modifier" id="ajout">
			
		</form>
	</div>
</body>
</html>