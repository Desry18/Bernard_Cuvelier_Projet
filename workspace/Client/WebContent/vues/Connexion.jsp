<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<body>
	<form action="LogUtil" method="POST">
		<table border="1">
			<tr>
			    <td>Pseudo : </td>
			    <td><input type="text" name="pseudo" id="pseudo"
			value="" size="20"/></td>
			</tr>
			<tr>
			    <td>Mot de passe : </td>
			    <td><input type="text" name="mdp" id="mdp"
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