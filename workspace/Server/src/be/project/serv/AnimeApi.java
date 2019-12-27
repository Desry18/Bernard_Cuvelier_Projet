package be.project.serv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ws.rs.core.Response.Status;

import be.projet.dao.SingletonDB;
import be.projet.pogo.Anime;


@Path("anime")
public class AnimeApi {
	
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAnimeJson() throws SQLException {
		
		Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String querry = "SELECT titre_anime, studio_anime, nbr_episode FROM anime";
    	List<Anime> listeAnime = new ArrayList<>();
        SingletonDB dbt= new SingletonDB();
        
        try {
            conn = dbt.getConnection();
            statement = conn.prepareStatement(querry);
            resultado = statement.executeQuery();
            
            
            while (resultado.next()) {
				String titre_anime = resultado.getString(1);
				String studio_anime = resultado.getString(2);
				int nbr_ep = resultado.getInt(3);
				
				listeAnime.add(new Anime(titre_anime, studio_anime, nbr_ep));

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
				.entity(listeAnime)
				.build();
		}
	}


