package be.project.serv;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataParam;

import be.projet.dao.SingletonDB;
import be.projet.pogo.Utilisateur;


@Path("utilisateur")
public class UtilApi {
	
	
	@Path("nouveauUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
public Response nouveauUtil(
		@FormDataParam("pseudo") String pseudo,
		@FormDataParam("email") String email,
		@FormDataParam("mdp") String mdp,
		@FormDataParam("nom_util") String nom_util
		) throws SQLException {
		
		Connection conn = null;
		PreparedStatement statement = null;
        ResultSet resultado = null;
        String querry ="insert into utilisateur(email, nom_util, pseudo, mdp) " + 
        		"	values(?,?,?,?)";
        SingletonDB dbt= new SingletonDB();
      
        try {
        	conn = dbt.getConnection();
            statement = conn.prepareStatement(querry);
            
            statement.setString(1,email);
            statement.setString(2,nom_util);
            statement.setString(3,pseudo);
            statement.setString(4,mdp);
            statement.executeUpdate();
          
            

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
		}

		return Response .status(200)
				.build();
		}
	
	
/*	@Path("changerPseudo")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
public Response changerPseudo(@FormParam("pseudo") String pseudo,
		@QueryParam("id_util") int id_util) throws SQLException {
		
		Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String querry ="BEGIN"
        		+ "updatePseudo(id_util,pseudo)"
        		+ "END"
        		+ "/";
        SingletonDB dbt= new SingletonDB();
        Utilisateur netP = null;
        
        try {
            conn = dbt.getConnection();
            statement = conn.prepareStatement(querry);
            resultado = statement.executeQuery();
            
				String pseudo1 = resultado.getString(1);
				netP= new Utilisateur(pseudo1);

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
				.entity(netP)
				.build();
		}
*/	
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUtilJson() throws SQLException {
		
		Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String querry = "SELECT email, pseudo, nom_util, mdp FROM utilisateur";
    	List<Utilisateur> listeUtil = new ArrayList<>();
        SingletonDB dbt= new SingletonDB();
        
        try {
            conn = dbt.getConnection();
            statement = conn.prepareStatement(querry);
            resultado = statement.executeQuery();
            
            
            while (resultado.next()) {
				String email = resultado.getString(1);
				String pseudo = resultado.getString(2);
				String mdp = resultado.getString(4);
				String nom = resultado.getString(3);
				
				listeUtil.add(new Utilisateur(pseudo, nom, mdp, email));

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
				.entity(listeUtil)
				.build();
		}
	}


