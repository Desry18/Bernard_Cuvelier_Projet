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
<%@ include file = "Chercher.jsp" %>
<table>
<%	
		HttpSession sessions = request.getSession(true);
		Manga mang = new Manga();
        List<Manga> lmanga = mang.getAllManga();
        if (lmanga != null) {
            if (lmanga.size() >= 1) {
                for (int i = 0; i < lmanga.size(); i++) {
                	out.println("<tr>");
                    Manga m = lmanga.get(i);
                	int id = m.getId_manga();
                    out.println("<td>");
                    out.println(m.getTitre_manga() + " </td><td>" + m.getEdit_manga() + " </td> <td>" + m.getNote_manga() +" </td> <td>" + m.getId_manga());
                    out.println("</td>");
                    out.println("<form action=\"allbymanga\" method=\"POST\">");
                    out.println("<input type = \"hidden\" name=\"num\" value = "+ m.getId_manga()+" />");
                    out.println("<button  name=\"valide\" value=\"valider\" type=\"submit\">Consulter</button>");
                    out.println("</form>"); 
                    out.println("<td><a type=\"button\" class=\"btn btn-primary\" href=\"AddAnime/" + m.getId_manga() + "\">Ajouter a ma liste</a></td>");
                    out.println("<td><a type=\"button\" class=\"btn btn-primary\" href=\"AddNote/" + m.getId_manga() + "\">Ajouter un point!</a></td>");
                	out.println("</tr>");
                	sessions.setAttribute("manga", m);

                }
            }
        }

%>
</table>
<%@ include file = "menu.jsp" %>

</body>
</html>