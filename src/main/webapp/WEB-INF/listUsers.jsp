<%@include file="includes/header.jsp" %>
<%@include file="includes/footer.jsp" %> 

<%-- <jsp:include page="includes/header.jsp"/> --%>

<%-- <c:import url="includes/header.jsp"/> --%>
	<h2 class="enteteList">Liste des utilisateurs</h2>
	<c:choose>
		<c:when test="${ empty utilisateurs }">
		<p>La liste des utilisateurs est vide !</p>
		</c:when>	
		<c:otherwise>
			<table border="1" cellspacing="0" cellpadding="10">
				<tr>
					<th>ID</th>
					<th>Prénom</th>
					<th>Nom</th>
					<th>Login</th>
					<th>Password</th>
					<th colspan="2">Actions</th>
				</tr>
				<c:forEach var="utilisateur"  items="${utilisateurs }">
				<tr>
						<td> <c:out value=" ${utilisateur.id}"/> </td>
						<td> <c:out value=" ${utilisateur.nom}"/> </td>
						<td> <c:out value=" ${utilisateur.prenom}"/> </td>
						<td> <c:out value=" ${utilisateur.login}"/> </td>
						<td> <c:out value=" ${utilisateur.password}"/> </td>
						<td><a href="updateUser?id=${ utilisateur.id }">Modifier</a> </td>
						<td> <a href="removeUser?id=${ utilisateur.id }"  onclick="return confirm('Voulez vous vraiment supprimer?')">Supprimer</a></td>
						
					</tr>
				</c:forEach>
				</table>
		</c:otherwise>
	
	</c:choose>



<%-- 	<h2 class="entete">Liste des utilisateurs</h2>
	<%
			ArrayList<User> utilisateurs = (ArrayList<User>)(request.getAttribute("utilisateurs"));
			
			(utilisateurs.isEmpty()){
	%>
		
		<p> La liste des utilisateurs est vide !</p><%}
			
			else{
				%>
			<table border="1" cellspacing="0" cellpadding="10">
				<tr>
					<th>ID</th>
					<th>Prénom</th>
					<th>Nom</th>
					<th>Login</th>
					<th>Password</th>
					<th>Actions</th>
				</tr><%}
				

						for(User utilisateur: utilisateurs){
							request.setAttribute("utilisateur" , utilisateur);
				%>
					<tr>
						<td> ${ utilisateur.id } </td>
						<td> ${ utilisateur.prenom } </td>
						<td> ${ utilisateur.nom }</td>
						<td> ${ utilisateur.login } </td>
						<td> ${ utilisateur.password }</td>
						<td><a href="updateUser?id=${ utilisateur.id }">Modifier</a> </td>
						<td> <a href="removeUser?id=${ utilisateur.id }" onclick="return confirm('Voulez vous vraiment supprimer?')">Supprimer</a></td>
						
					</tr><% 
				}%>

			</table><%
	%> --%>
</body>
</html>