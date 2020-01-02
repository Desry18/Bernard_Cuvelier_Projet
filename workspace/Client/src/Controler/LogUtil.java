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
 * Servlet implementation class LogUtil
 */
@WebServlet("/LogUtil")
public class LogUtil extends javax.servlet.http.HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogUtil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo;
	    String mdp;
	    if (request.getParameter("submit") != null) {
	      pseudo = request.getParameter("pseudo");
	      mdp = request.getParameter("mdp");
	      Utilisateur u = new Utilisateur();
	      if (u.log(pseudo, mdp)) {
	        HttpSession session = request.getSession();
	        session.setAttribute("util", u);
	        response.sendRedirect("/ok_bommer/Activity/");
	      } else {
	        response.sendRedirect("/ok_bommer/Index/");
	      }
	    }
	}

	/**
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(
		      javax.servlet.http.HttpServletRequest request,
		      javax.servlet.http.HttpServletResponse response)
		      throws IOException, ServletException {
		    doGet(request, response);
		  }

}
