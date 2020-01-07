<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.projet.pojo.Manga" %>  
<%@ page import="java.util.List" %>     
<%@ page import="be.projet.pojo.Utilisateur" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    Utilisateur u = null;
    if (session.getAttribute("util") != null) {
        u = (Utilisateur) session.getAttribute("util");
    } 
%>

<%
        if (u.recherche(request.getParameter("keyword")) != null) {
            List<Manga> li = u.recherche(request.getParameter("keyword"));
            if (li.size() >= 1) {
                for (int i = 0; i < li.size(); i++) {
                    Manga m = li.get(i);
                    out.println(m.getTitre_manga() + " " + m.getEdit_manga() + "<p>" +m.getNbr_tome() + "</p>");
                   
                }
            }else{out.print("Chercher introuvable, Essayer à nouveau" );}
        }
    %>
    <%@ include file = "menu.jsp" %>
</body>
</html>