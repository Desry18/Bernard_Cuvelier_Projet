package Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.projet.pojo.ListeManga;
import be.projet.pojo.Manga;
import be.projet.pojo.Utilisateur;

/**
 * Servlet implementation class GetAllManga
 */
//@WebServlet("/GetAllManga")
public class GetAllManga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllManga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Manga tableManga = new Manga();
		//List <Manga> listeAllManga = tableManga.getAllManga();
		//request.setAttribute("AllManga", listeAllManga);
    	getServletContext().getRequestDispatcher("/vues\\AllManga.jsp").forward(request, response);
		/*response.setContentType("text/HTML");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ListeManga lm = new ListeManga();
		List <ListeManga> lmall = lm.getAllListeManga();
		Utilisateur u = new Utilisateur();
		List<Utilisateur> ul = u.getAllUtil();
		for(int i = 0; i < listeAllManga.size(); i++)
			out.println("TestManga : " + i + " " + listeAllManga.get(i).getTitre_manga());
*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
