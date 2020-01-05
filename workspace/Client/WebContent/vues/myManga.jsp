<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.projet.pojo.Utilisateur" %> 
<%@ page import="be.projet.pojo.ListeManga" %> 
<%@ page import="java.util.List" %> 
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    Utilisateur u = null;
    session = request.getSession();
    if (session != null) {
        if (session.getAttribute("util") != null) {
            u = (Utilisateur) session.getAttribute("util");
        } else {
            response.sendRedirect("/Ok_Bommer/Index/");
        }
    } else
        response.sendRedirect("/ok_bommer/Index/");
%>


    <%
    	int k= u.getId_util();
    ListeManga ma = new ListeManga();
        List<ListeManga> lmanga = ma.getAllme(k);
		
        if (lmanga != null) {
            if (lmanga.size() >= 1) {
                for (int i = 0; i < lmanga.size(); i++) {
                   ListeManga m = lmanga.get(i);
                    out.println( m.getTitre_manga());
                    out.println("<a type=\"button\" href=\"/ok_borber/Consultermanga?id=" + m.getId_manga() + "\">Consulter</a>");
          
                    out.println("<a type=\"button\" href=\"/ok_bomer/AddNote?id=" + m.getId_manga() + "\">Ajouter un point!</a>");
                  
                }
            }
        }
    %>
</body>
</html>