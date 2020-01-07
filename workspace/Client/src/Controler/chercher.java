package Controler;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class chercher
 */
//@WebServlet("/chercher")
public class chercher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String recher= null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chercher() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	ServletConfig config=getServletConfig();
    	recher=(String)config.getInitParameter("findM");
    	 	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String l;
		 if (request.getParameter("valider") != null) {
		      l = request.getParameter("keyword");
		      getServletContext().getRequestDispatcher(recher).forward(request, response);
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
