package be.project.serv;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import be.projet.dao.ConnectDB;
import be.projet.dao.UtilisateurDAO;
import be.projet.pojo.Utilisateur;


@Path("utilisateur")
public class UtilApi extends RestApplication{
	private Response rep;
	private Connection conn;
	
	
	@Path("nouvelUtilisateur")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
public Response nouveauUtil(
		@FormParam("Id") int Id,
		@FormParam("pseudo") String pseudo,
		@FormParam("email") String email,
		@FormParam("mdp") String mdp,
		@FormParam("nom_util") String nom_util
		) {
			try {
				conn = ConnectDB.getInstance().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Utilisateur util = new Utilisateur();
			util.setId(Id);
			util.setEmail(email);
			util.setMdp(mdp);
			util.setNom_util(nom_util);
			util.setPseudo(pseudo);		
			boolean ajout = new UtilisateurDAO(conn).create(util);
			if(ajout) rep = Response.status(Status.OK).build();
			else rep = Response.status(Response.Status.BAD_REQUEST).entity(util).build();	
			return rep;
		}
	

	@Path("changerPseudo")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response changerPseudo(
		@FormParam("pseudo") String pseudo,
		@FormParam("id") int id_util) {
		
        try {
			conn = ConnectDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utilisateur util = new Utilisateur();
		util.setId(id_util);
        util.setPseudo(pseudo);
        boolean modif = new UtilisateurDAO(conn).update(util);
        if (modif)
        	rep = Response .status(Response.Status.OK).entity(true).build();
        else
        	rep = Response .status(Response.Status.BAD_REQUEST).entity(null).build();
        return rep;
	}

 

	@Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUtilJson() {
		try {
			conn = ConnectDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rep = Response.status(Response.Status.OK).entity(new UtilisateurDAO(conn).getAll()).build();
		return rep;
		}
	}