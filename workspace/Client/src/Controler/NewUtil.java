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
 * Servlet implementation class NewUtil
 */
@WebServlet("/NewUtil")
public class NewUtil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUtil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email;
	    String nom;
	    String pseudo;
	    String mdp;
	   
	    if (request.getParameter("submit") != null) {
	      email = request.getParameter("email");
	      nom = request.getParameter("nom_util");
	      pseudo = request.getParameter("pseudo");
	      mdp = request.getParameter("mdp");
	      if (email != null && nom != null && pseudo != null && mdp != null) {
	        Utilisateur u = new Utilisateur();
	        if (u.enregistrer(email,nom, pseudo,mdp)) {
	          HttpSession session = request.getSession();
	          session.setAttribute("user", u);
	          response.sendRedirect("/ok_bommer/Activity/");
	        } else {
	          response.sendRedirect("/ok_bommer/Index/");
	        }
	      } else {
	        response.sendRedirect("/ok_bommer/Index/");
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
