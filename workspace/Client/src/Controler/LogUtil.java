package Controler;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
//@WebServlet("/LogUtil")
public class LogUtil extends javax.servlet.http.HttpServlet{
	private static final long serialVersionUID = 1L;
	String urlReussite = null;
	String urlErr = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init()
	{
		//ServletContext ctxt = getServletContext();
		ServletConfig config = getServletConfig();
		String urlReussite = config.getInitParameter("urlReussite");
		String urlErr = config.getInitParameter("urlechec");
	}
	
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
	    if (request.getParameter("valider") != null) {
	      pseudo = request.getParameter("pseudo");
	      mdp = request.getParameter("mdp");
	      Utilisateur u = new Utilisateur();
	      if (u.log(pseudo, mdp)) {
	        HttpSession session = request.getSession();
	        session.setAttribute("util", u);
		 	//response.sendRedirect("/Vues/UtilisateurIndex.jsp");
	        getServletContext().getRequestDispatcher(urlReussite).forward(request, response);
	      } else {
			 	//response.sendRedirect("Index.jsp");

	    	  getServletContext().getRequestDispatcher(urlErr).forward(request, response);
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
