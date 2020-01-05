package Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.projet.pojo.Anime;
import be.projet.pojo.ListeManga;
import be.projet.pojo.Manga;
import be.projet.pojo.Utilisateur;

/**
 * Servlet implementation class test2
 */
//@WebServlet("/test2")
public class test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
    	//getServletContext().getRequestDispatcher("/vues\\myManga.jsp").forward(request, response);
		response.setContentType("text/HTML");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Anime lm = new Anime();
		Utilisateur u = new Utilisateur();
		u = (Utilisateur) session.getAttribute("util");	
		List<Anime> li=lm.findi("P");
		out.println(li.get(0).getTitre_anime());	
		out.println("Va apprendre à utiliser les sessions connards de " + u.getId_util());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
