package Controler;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.projet.pojo.Utilisateur;

/**
 * Servlet implementation class ConsulterAnime
 */
@WebServlet("/ConsulterAnime")
public class ConsulterAnime extends HttpServlet {
	private static final long serialVersionUID = 1L;
     String urlAnime=null;
     String allManga=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterAnime() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	ServletConfig config=getServletConfig();
    	urlAnime=(String)config.getInitParameter("urlAnime");
    	allManga=(String)config.getInitParameter("allManga");
    	 	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id;
	    Utilisateur util;
	    HttpSession session = request.getSession();
	    if (request.getParameter("id") != null) {
	      id = request.getParameter("id");
	      if (session.getAttribute("util") != null) {
	        util = (Utilisateur) session.getAttribute("util");
	        util.consulterA(Integer.parseInt(id));
			request.setAttribute("anime", util);
			getServletContext().getRequestDispatcher(urlAnime).forward(request, response);
	      }getServletContext().getRequestDispatcher(allManga).forward(request, response);
	    }getServletContext().getRequestDispatcher(allManga).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
