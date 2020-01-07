<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.projet.pojo.Manga" %>  
<%@ page import="be.projet.pojo.Utilisateur" %> 
<%@ page import="be.projet.pojo.ListeManga" %>  

<%@ page import="java.util.List" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Utilisateur u =(Utilisateur) session.getAttribute("util");
	List<ListeManga> lm = u.getAllme(u.getId_util());
	 if (lm != null) {
         if (lm.size() >= 1) {
             for (int i = 0; i < lm.size(); i++)
             {
            	 out.println(u.getMangaById(lm.get(i).getId_manga()).getTitre_manga());
            	 out.println("<br>");
             }
         }
	 }
%>

</body>
</html>