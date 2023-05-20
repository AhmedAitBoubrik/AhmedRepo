<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
</head>
<body>
	<%!
		String makeCode(){
			int NBR = (int) Math.random() * 1000;
			return "CNE-"+NBR;
		}
	%>
	<form action="save" method="post" class="form form-primary">
		<h1>Gestion Etudiant</h1>
		<p>
			<label for="code">Code:</label>
			<input type="text" id="code" name="code" value="${index.makeCode()}"/>
		</p>
		<p>
			<label for="nom">Nom:</label>
			<input type="text" id="nom" name="nom"/>
		</p>
		<p>
			<label for="prenom">Prenom:</label>
			<input type="text" id="prenom" name="prenom"/>
		</p>
		<p>
			<label for="age">Age:</label>
			<input type="number" id="age" name="age"/>
		</p>
		<p>
			<label for="ville">Ville:</label>
			<input type="text" id="ville" name="ville"/>
		</p>
		<p>
			<input type="submit" value="valider" class="btn btn-danger"/>
		</p>
	</form>
	
	
	<table border="2px">
		<tr><th>Code</th><th>Nom</th><th>Prenom</th><th>Age</th><th>Ville</th></tr>
		<tr>
			<c:forEach items="${liste}" var="etudiant">
				<td>${etudiant.getCode()}</td>
				<td>${etudiant.getNom()}</td>
				<td>${etudiant.getPrenom()}</td>
				<td>${etudiant.getAge()}</td>
				<td>${etudiant.getVille()}</td>
				<td><a href="delete?code=${etudiant.getCode()}"><img src="delete_fire.png"/></a></td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>