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
 * Servlet implementation class DeleteListeManga
 */
//@WebServlet("/DeleteListeManga")
public class DeleteListeManga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteListeManga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i;
		int l;
		Utilisateur util;
		 if (request.getParameter("validerthis") != null) {
			HttpSession session = request.getSession();
			util = (Utilisateur) session.getAttribute("util");
			l= util.getId_util();
			i = Integer.parseInt((String)request.getParameter("valeur"));
			ListeManga m= new ListeManga();
			boolean ok=m.delete(l, i);
			if(ok==true) {
				getServletContext().getRequestDispatcher("/vues\\MaListe.jsp").forward(request, response);
			}else {
				getServletContext().getRequestDispatcher("/vues\\MaListe.jsp").forward(request, response);

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
