<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="NewUtil" method="POST">
		<table border="1">
			<tr>
			    <td>Pseudo : </td>
			    <td><input type="text" name="Pseudo" id="pseudo"
			value="" size="20"/></td>
			</tr>
			<tr>
			    <td>Mot de passe : </td>
			    <td><input type="text" name="motdepasse" id="mdp"
			value="" size="20"/></td>
			</tr>
				<tr>
			    <td>Email</td>
			    <td><input type="text" name="Email" id="mail"
			value="" size="20"/></td>
			</tr>	<tr>
			    <td>Nom</td>
			    <td><input type="text" name="Nom" id="nom"
			value="" size="20"/></td>
			</tr>
			<tr>
			    <td colspan="2" align="center"><input type="submit"
			name="valider" id="valider" value="Valider"/></td>
			</tr>
		</table>
		</form>
</body>
</html>