<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<table>
<%

		Manga mang = new Manga();
        List<Manga> lmanga = mang.getAllManga();
        if (lmanga != null) {
            if (lmanga.size() >= 1) {
                for (int i = 0; i < lmanga.size(); i++) {
                	out.println("<tr>");
                    Manga m = lmanga.get(i);
                    out.println("<td>");
                    out.println(m.getTitre_manga() + " </td><td>" + m.getEdit_manga() + " </td> <td>" + m.getNote_manga());
                    out.println("</td>");
                    out.println("<td><a type=\"button\" href=\"/ok_borber/Consultermanga?id=" + m.getId_manga()+ "\">Consulter</a></td>");           
                    out.println("<td><a type=\"button\" class=\"btn btn-primary\" href=\"/ok_bomer/AddManga?id=" + m.getId_manga() + "\">Ajouter à ma liste</a></td>");
                    out.println("<td><a type=\"button\" class=\"btn btn-primary\" href=\"/ok_bomer/AddNote?id=" + m.getId_manga() + "\">Ajouter un point!</a></td>");
                	out.println("</tr>");

                }
            }
        }

%>
</table>
<%@ include file = "menu.jsp" %>

</body>
</html>