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

import be.projet.pojo.ListeManga;
import be.projet.pojo.Manga;
import be.projet.pojo.Utilisateur;

/**
 * Servlet implementation class test1
 */
//@WebServlet("/test1")
public class test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//getServletContext().getRequestDispatcher("/vues\\myManga.jsp").forward(request, response);
		response.setContentType("text/HTML");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ListeManga lm = new ListeManga();
		Utilisateur u = new Utilisateur();
		u = (Utilisateur) session.getAttribute("util");	
		List<ListeManga> lma = lm.getAllme(u.getId_util());
		out.println(lma.get(0).getId_manga());	
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
