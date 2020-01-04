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
import be.projet.dao.UtilisateurDAO;
import be.projet.pojo.Anime;
import be.projet.pojo.Manga;
import be.projet.pojo.Utilisateur;


@Path("anime")
public class AnimeApi {
	private Response rep;
	private Connection conn;

	@Path("recupAnimeByTitre")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response recupAnimeByTitre(
		@QueryParam("lettre") String l) {
		
        try {
			conn = ConnectDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Anime> list = new AnimeDAO(conn).find(l);
       
        if (list != null)
        	rep = Response .status(Response.Status.OK).entity(list).build();
        else
        	rep = Response .status(Response.Status.NO_CONTENT).entity(null).build();
        return rep;
	}

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
	
	@Path("getAllById")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllIDJson(@QueryParam("id") int id) {

        try {
			conn = ConnectDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Anime> list = new AnimeDAO(conn).findall(id);
       
        if (list != null)
        	rep = Response .status(Response.Status.OK).entity(list).build();
        else
        	rep = Response .status(Response.Status.NO_CONTENT).entity(null).build();
        return rep;
	}
	
	}