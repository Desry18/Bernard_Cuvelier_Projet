package be.project.serv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ws.rs.core.Response.Status;

import be.projet.dao.ConnectDB;
import be.projet.dao.MangaDAO;
import be.projet.pojo.Manga;


@Path("manga")
public class MangaApi {
	private Response rep;
	private Connection conn;
/*
	@Path("find")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
public Response findManga(@FormParam("let") String let) throws SQLException {
		
		Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String querry ="BEGING"
        		+ "trouvermanga.afficher_manga(let)"
        		+ "END"
        		+ "/";
    	List<Manga> listmanga = new ArrayList<>();
        ConnectDB dbt= new ConnectDB();
        
        try {
            conn = dbt.getConnection();
            statement = conn.prepareStatement(querry);
            resultado = statement.executeQuery();
            
            
            while (resultado.next()) {
				String titre_manga = resultado.getString(1);
				String editeur_manga = resultado.getString(2);
				int nbr_tome = resultado.getInt(3);
				
				listmanga.add(new Manga(titre_manga, editeur_manga, nbr_tome));
        }
        }catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if( resultado!= null) {
				try {
					resultado.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return Response .status(Status.OK)
				.entity(listmanga)
				.build();
		}
	
*/	
	@Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMangaJson() {
	try {
		conn = ConnectDB.getInstance().getConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	rep = Response.status(Response.Status.OK).entity(new MangaDAO(conn).getAll()).build();
	return rep;
	}
}