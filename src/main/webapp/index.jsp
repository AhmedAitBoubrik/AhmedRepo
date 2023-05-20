<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.* " %>
<%@ page import="java.lang.Math.* " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! String code;String a="Ahmed"; %>

<%!
public String   genere(String code){
	 code="CNE-"+(int)(Math.random()*100);
	return code;
}

%>
<form method="Post" action="SaveEtudiant" >
<table>
<tr>
<td colspan="2"><h4>Gestion des étudiants</h4></td>
</tr>
<tr>
<td>Code:</td>
<td><input type="text" name="code" value="<%=genere(code) %>"></td> 
</tr>
<tr>
<td>Nom:</td>
<td><input type="text" name="nom"></td>
</tr>
<tr>
<td>Prénom:</td>
<td><input type="text" name="prenom"></td>
</tr>
<tr>
<td>Age:</td>
<td><input type="text" name="age"></td>
</tr>
<tr>
<td>Ville:</td>
<td><input type="text" name="ville"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Valider"></td>
</tr>
</table>
</form>
</body>
</html>