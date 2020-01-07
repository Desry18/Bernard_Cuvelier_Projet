<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="be.projet.pojo.Anime" %>  
<%@ page import="java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Tous les Animes : </h1>

<table>
<tr>
<td> TITRE </td>
<td> STUDIO </td>
<td> NOMBRE D'EPISODES </td>
<%

		Anime anime = new Anime();
        List<Anime> lAnime = anime.getAllAnime();
        if (lAnime != null) {
            if (lAnime.size() >= 1) {
                for (int i = 0; i < lAnime.size(); i++) {
                	out.println("<tr>");
                    Anime a = lAnime.get(i);
                    out.println("<td>"+a.getTitre_anime() + "</td><td>" + a.getStudio_anime() + " </td> <td>" + a.getNote_anime() + "</td><td>"+ a.getNbr_episode() + "</td>");
                    //out.println("<td><a type=\" href=\"AddAnime/" + a.getId_anime() + "\">Ajouter à ma liste</a></td>");
                    out.println("<td><a type=\"button\" class=\"btn btn-primary\" href=\"/ok_bomer/AddNote?id=" + a.getId_anime() + "\">Ajouter un point!</a></td>");
                	out.println("</tr>");

                }
            }
        }

%>
</tr>
</table>
<%@ include file = "menu.jsp" %>
</body>
</html>