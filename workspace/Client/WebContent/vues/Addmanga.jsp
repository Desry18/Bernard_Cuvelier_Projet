<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="newManga" method="POST">
		<table border="1">
			<tr>
			    <td>Titre : </td>
			    <td><input type="text" name="titre" id="titre"
			value="" size="20"/></td>
			</tr>
			<tr>
			    <td>Editeur : </td>
			    <td><input type="text" name="edit" id="edit"
			value="" size="20"/></td>
			</tr>
				<tr>
			    <td>Nombre de tome </td>
			    <td><input type="text" name="tom" id="tom"
			value="" size="20"/></td>
			</tr>	<tr>
			    <td>Date de sortie : </td>
			    <td><input type="text" name="date" id="date"
			value="" size="20"/></td>
			</tr>
			<tr>
			    <td colspan="2" align="center"><input type="submit"
			name="validation" id="valider" value="Valider"/></td>
			</tr>
		</table>
		</form>
</body>
</html>