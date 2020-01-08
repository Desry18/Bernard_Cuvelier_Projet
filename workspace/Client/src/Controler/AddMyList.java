package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.projet.pojo.ListeManga;
import be.projet.pojo.Utilisateur;

/**
 * Servlet implementation class AddMyList
 */
//@WebServlet("/AddMyList")
public class AddMyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMyList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int i;
		int l;
		Utilisateur util;
		 if (request.getParameter("ok") != null) {
			 HttpSession sessions = request.getSession();
			  util = (Utilisateur) sessions.getAttribute("util");
			 l= util.getId_util();
			 i = Integer.parseInt((String)request.getParameter("ok"));
			ListeManga m= new ListeManga();
			boolean ok=m.createMangalist(l, i);
			if(ok==true) {
				getServletContext().getRequestDispatcher("/vues\\menus.jsp").forward(request, response);
			}else {
				getServletContext().getRequestDispatcher("/vues\\AllAnime.jsp").forward(request, response);
			}
			
			 
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
