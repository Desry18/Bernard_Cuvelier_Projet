package be.project.serv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
        Manga a = new Manga();
        a.setId_manga(id);
		List<Anime> list = new AnimeDAO(conn).findAn(a);
       
        if (list != null)
        	rep = Response .status(Response.Status.OK).entity(list).build();
        else
        	rep = Response .status(Response.Status.NO_CONTENT).entity(null).build();
        return rep;
	}
	@Path("nouvelanime")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
public Response nouveauAnime(
		@FormParam("titre_anime") String titre,
		@FormParam("studio_anime") String studio,
		@FormParam("date_sortie_anime") Timestamp date_p,
		@FormParam("nbr_episode") int nbr_e,
		@FormParam("note_anime") int note
		) {
			try {
				conn = ConnectDB.getInstance().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Anime ma = new Anime();
			ma.setTitre_anime(titre);
			ma.setStudio_anime(studio);
			ma.setDate_sortie_anime(date_p);
			ma.setNbr_episode(nbr_e);
			ma.setNote_anime(note);		
			boolean ajout = new AnimeDAO(conn).create(ma);
			if(ajout) rep = Response.status(Status.OK).build();
			else rep = Response.status(Response.Status.BAD_REQUEST).entity(ma).build();	
			return rep;
		}
	
	@Path("delanime")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
public Response deleteanime(
		@QueryParam("id_anime") int ia
		) {
			 try {
			conn = ConnectDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Anime li = new Anime();
		li.setId_anime(ia);
       boolean ajout = new AnimeDAO(conn).delete(li);
			if(ajout) rep = Response.status(Status.OK).build();
			else rep = Response.status(Response.Status.BAD_REQUEST).entity(li).build();	
			return rep;
		}	
	
	@Path("ChangerNbEp")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response changerNbTome(
			@QueryParam("id") int id,
			@FormParam("nbr_episode") int ne
			) {
		try {
			conn = ConnectDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Anime ma = new Anime();
		ma.setId_anime(id);
		ma.setNbr_episode(ne);
		
		boolean ajout = new AnimeDAO(conn).update(ma);
		if (ajout)
			rep = Response.status(Response.Status.OK).entity(true).build();
		else
			rep = Response.status(Response.Status.BAD_REQUEST).entity(null).build();	
		
		return rep;
	}
	}