package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.projet.pojo.Manga;
import be.projet.pojo.Utilisateur;

/**
 * Servlet implementation class NewManga
 */
//@WebServlet("/NewManga")
public class NewManga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewManga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String titre;
		String edit;
		int nb_t;
		String d;
	   
	    if (request.getParameter("valider") != null) {
	      titre = request.getParameter("titre");
	      edit = request.getParameter("edit");
	      nb_t = Integer.parseInt((String)request.getParameter("tom"));
	      d = request.getParameter("date");
	      if (titre != null && edit != null && d != null) {
	       Manga m= new Manga();
	        if (!m.createManga(titre,edit,nb_t,d)) {
	          HttpSession session = request.getSession();
	          session.setAttribute("manga", m);
		        getServletContext().getRequestDispatcher("/vues\\MenuAdmin.jsp").forward(request, response);
	        }
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
