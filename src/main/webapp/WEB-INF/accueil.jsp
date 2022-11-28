<%@include file="includes/header.jsp" %>
<%@include file="includes/footer.jsp" %> 

<%-- <jsp:include page="includes/header.jsp"/> --%>

<%-- <c:import url="includes/header.jsp"/> --%>
	<h2 class="entete">Liste des utilisateurs</h2> 
	<c:choose>
		<c:when test="${ empty utilisateurs }">
		<p>La liste des utilisateurs est vide !</p>
		</c:when>	
		<c:otherwise>
		<br/>
			<table border="1" cellspacing="0" cellpadding="10">
				<tr>
					<th>ID</th>
					<th>Prénom</th>
					<th>Nom</th>
					<th>Login</th>
					<th>Password</th>
				</tr>
				<c:forEach var="utilisateur"  items="${utilisateurs }">
				<tr>
						<td> <c:out value=" ${utilisateur.id}"/> </td>
						<td> <c:out value=" ${utilisateur.nom}"/> </td>
						<td> <c:out value=" ${utilisateur.prenom}"/> </td>
						<td> <c:out value=" ${utilisateur.login}"/> </td>
						<td> <c:out value=" ${utilisateur.password}"/> </td>
				</tr>
				</c:forEach>
				</table>
		</c:otherwise>
	
	</c:choose>
