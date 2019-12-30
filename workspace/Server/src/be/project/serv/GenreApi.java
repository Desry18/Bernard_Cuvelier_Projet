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
import be.projet.pogo.Genre;


@Path("genre")
public class GenreApi {
	
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllGenreJson() throws SQLException {
		
		Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String querry = "SELECT libel_genre FROM genre";
    	List<Genre> listeGenre = new ArrayList<>();
        SingletonDB dbt= new SingletonDB();
        
        try {
            conn = dbt.getConnection();
            statement = conn.prepareStatement(querry);
            resultado = statement.executeQuery();
            
            
            while (resultado.next()) {
				String libel_genre = resultado.getString(1);				
				listeGenre.add(new Genre(libel_genre));

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
		
        
<<<<<<< HEAD
=======
	

>>>>>>> parent of 1f08b0f... FullDAO
		return Response .status(Status.OK)
				.entity(listeGenre)
				.build();
		}
	}


