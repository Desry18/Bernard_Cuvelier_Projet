package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.projet.pojo.Utilisateur;

/**
 * Servlet implementation class AddManga
 */
@WebServlet("/AddManga")
public class AddManga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddManga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String id;
		    Utilisateur util;
		    HttpSession session = request.getSession();
		    if (request.getParameter("id") != null) {
		      id = request.getParameter("id");
		      if (session.getAttribute("util") != null) {
		        util = (Utilisateur) session.getAttribute("util");
		        util.ajouterAMaList(Integer.parseInt(id));
		        response.sendRedirect("/vues/menu/");
		      } else response.sendRedirect("/vues/menu/");
		    } else response.sendRedirect("/vues/menu/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
