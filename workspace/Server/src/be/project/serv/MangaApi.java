package be.project.serv;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.projet.dao.AnimeDAO;
import be.projet.dao.ConnectDB;
import be.projet.dao.MangaDAO;
import be.projet.pojo.Anime;
import be.projet.pojo.Manga;


@Path("manga")
public class MangaApi {
	private Response rep;
	private Connection conn;
	
	
	@Path("recupMangaByTitre")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response recupMangaByTitre(
		@QueryParam("lettre") String l) {
		
        try {
			conn = ConnectDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Manga> list = new MangaDAO(conn).find(l);
       
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
	rep = Response.status(Response.Status.OK).entity(new MangaDAO(conn).getAll()).build();
	return rep;
	}
	
	@Path("getById")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getbyId(
		@QueryParam("id") int id) {
		
        try {
			conn = ConnectDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Manga mang = new MangaDAO(conn).find(id);
       
        if (mang != null)
        	rep = Response .status(Response.Status.OK).entity(mang).build();
        else
        	rep = Response .status(Response.Status.NO_CONTENT).entity(null).build();
        return rep;
	}
	
}