package Controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logAdmin
 */
@WebServlet("/logAdmin")
public class logAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String ident=null;
	String mdp=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	ServletConfig config=getServletConfig();
    	ident=(String)config.getInitParameter("defautIdentifiant");
    	mdp=(String)config.getInitParameter("defautMotDePasse");
    	
    	 	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String identifiant=request.getParameter("identifiant");
		
		String motdepasse = request.getParameter("motdepasse");
		PrintWriter out= response.getWriter();
		
		if(request.getParameter("valider")!=null) {
		if(identifiant ==null) {
			out.println("Autentification incorrect :");	
			response.sendRedirect("Admin.html");
		}	
		if(motdepasse==null)
        {         
			out.println("Authentification incorrecte !");
			response.sendRedirect("Admin.html");
        }

        if((identifiant!=null && identifiant.equals(ident))
        			&& (motdepasse!=null && motdepasse.equals(mdp)) )
        {
        	HttpSession session = request.getSession();
        	session.setAttribute("identifiant", identifiant);
        	session.setAttribute("motdepasse",motdepasse);
        	getServletContext().getRequestDispatcher("/vues\\MenuAdmin.jsp").forward(request, response);
        }else
        {
        out.println("Authentification incorrecte, mauvaise saisie des informations !");
        	response.sendRedirect("Admin.html");
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
