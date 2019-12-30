package be.project.serv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ws.rs.core.Response.Status;

import be.projet.dao.AnimeDAO;
import be.projet.dao.ConnectDB;
import be.projet.dao.MangaDAO;
import be.projet.pojo.Anime;
import be.projet.pojo.Manga;


@Path("anime")
public class AnimeApi {
	private Response rep;
	private Connection conn;
/*
	@Path("find")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
public Response findAnime(@QueryParam("let") String let) throws SQLException {
		
		Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String querry ="BEGING"
        		+ "trouveranime.afficher_anime(let)"
        		+ "END"
        		+ "/";
    	List<Anime> listanime = new ArrayList<>();
        ConnectDB dbt= new ConnectDB();
        
        try {
            conn = dbt.getConnection();
            statement = conn.prepareStatement(querry);
            resultado = statement.executeQuery();
            
            
            while (resultado.next()) {
				String titre_anime = resultado.getString(1);
				String studio_anime = resultado.getString(2);
				int nbr_episode = resultado.getInt(3);
				
				listanime.add(new Anime(titre_anime, studio_anime, nbr_episode));
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
				.entity(listanime)
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
	rep = Response.status(Response.Status.OK).entity(new AnimeDAO(conn).getAll()).build();
	return rep;
	}
	}