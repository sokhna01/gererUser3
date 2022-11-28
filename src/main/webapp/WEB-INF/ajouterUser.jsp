<%@include file="includes/header.jsp" %>
<%@include file="includes/footer.jsp" %>
	<div class="registration-form">
	<br/> <br/> <br/>
		<h3 class="entete">Ajouter un utilisateur</h3>
		<p class="messageBox ${status ? 'success' : 'erreur' }">${ statusMessage }</p>
		
		<form method="post">

				<label for="nom">Nom</label><br>
				<input class="simpleInput" type="text" name="nom" id="nom" value="${utilisateur.nom }"><br>
				<span class="erreur">${ erreurs.nom }</span>		
				
				<br/>
				<label for="prenom">Prénom</label><br>
				<input class="simpleInput" type="text" name="prenom" id="prenom" value="${utilisateur.prenom }"><br>
				<span class="erreur">${ erreurs.prenom }</span>	
				
				<br/>
				<label for="login">Login</label><br>
				<input class="simpleInput" type="text" name="login" id="login" value="${utilisateur.login }"><br>
				<span class="erreur">${ erreurs.login }</span>	
				
				<br/>
				<label for="password">Password</label><br>
	 			<input  class="simpleInput" type="text" name="password" id="password"><br><br>
	 			<span class="erreur">${ erreurs.password }</span>
	 				
	 			<br/>
	 			<label for="passwordBis">Confirm Password</label><br>
	 			<input  class="simpleInput" type="text" name="passwordBis" id="passwordBis"><br><br>
	 			<span class="erreur">${ erreurs.passwordBis }</span>	
	 		
			
				<input type="submit" value="Ajouter" id="ajout">
			
		</form>
	</div>
</body>
</html>