<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.projet.pojo.Utilisateur" %> 
<%@ page import="be.projet.pojo.Manga" %>  
<%@ page import="java.util.List" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Tous les manga : </h1>
<%
    Utilisateur u = null;
    session = request.getSession();
    if (session != null) {
        if (session.getAttribute("util") != null) {
            u = (Utilisateur) session.getAttribute("util");
        } else {
            response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
        }
    } else
        response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
%>

<p>
<%
        List<Manga> lmanga = u.getAll();
        if (lmanga != null) {
            if (lmanga.size() >= 1) {
                for (int i = 0; i < lmanga.size(); i++) {
                    Manga m = lmanga.get(i);
                    out.println(m.getTitre_manga() + " " + m.getEdit_manga() + " " + m.getNote_manga() );
                    out.println("<a type=\"button\" href=\"/ok_borber/Consultermanga?id=" + m.getId_manga()+ "\">Consulter</a>");
           
                    out.println("<a type=\"button\" class=\"btn btn-primary\" href=\"/ok_bomer/AddManga?id=" + m.getId_manga() + "\">Ajouter à ma liste</a>");
                    out.println("<a type=\"button\" class=\"btn btn-primary\" href=\"/ok_bomer/AddNote?id=" + m.getId_manga() + "\">Ajouter un point!</a>");
                   
                }
            }
        }
    %>
	
</p>
	
<%@ include file = "menu.jsp" %>

</body>
</html>