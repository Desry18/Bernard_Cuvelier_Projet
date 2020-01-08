package be.project.serv;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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


@Path("manga")
public class MangaApi {
	private Response rep;
	private Connection conn;
	
	
	@Path("recupMangaByTitre/{lettre}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response recupMangaByTitre(
		@PathParam("lettre") String l) {
		
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
	
	@Path("getById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getbyId(
		@PathParam("id") int id) {
		
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
	
	@Path("nouveauManga")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
public Response nouveauManga(
		@FormParam("titre_manga") String titre,
		@FormParam("edit_manga") String edit,
		@FormParam("date_parution") String date_p,
		@FormParam("nbr_tome") int nbr_t,
		@FormParam("note") int note
		) {
			try {
				conn = ConnectDB.getInstance().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Manga ma = new Manga();
			ma.setTitre_manga(titre);
			ma.setEdit_manga(edit);
			ma.setDate_parution(date_p);
			ma.setNbr_tome(nbr_t);
			ma.setNote_manga(note);
			boolean ajout = new MangaDAO(conn).create(ma);
			if(ajout) rep = Response.status(Status.OK).build();
			else rep = Response.status(Response.Status.BAD_REQUEST).entity(ma).build();	
			return rep;
		}

	@Path("delmanga")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
public Response deletemanga(
		@QueryParam("id_manga") int ia
		) {
			 try {
			conn = ConnectDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Manga li = new Manga();
		li.setId_manga(ia);
        boolean ajout = new MangaDAO(conn).delete(li);
			if(ajout) rep = Response.status(Status.OK).build();
			else rep = Response.status(Response.Status.BAD_REQUEST).entity(li).build();	
			return rep;
		}	
	
	@Path("ChangerNbTome")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response changerNbTome(
			@QueryParam("id") int id,
			@FormParam("nbr_tome") int nbr
			) {
		try {
			conn = ConnectDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Manga ma = new Manga();
		ma.setId_manga(id);
		ma.setNbr_tome(nbr);
		
		boolean ajout = new MangaDAO(conn).update(ma);
		if (ajout)
			rep = Response.status(Response.Status.OK).entity(true).build();
		else
			rep = Response.status(Response.Status.BAD_REQUEST).entity(null).build();	
		
		return rep;
	}
	
	@Path("upDate/{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateNote(
		@PathParam("id") int id) {
		
        try {
			conn = ConnectDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Manga ma= new Manga();
        ma.setId_manga(id);
        
		boolean mang = new MangaDAO(conn).update(ma);
       
		if (mang)
			rep = Response.status(Response.Status.OK).entity(true).build();
		else
			rep = Response.status(Response.Status.BAD_REQUEST).entity(null).build();	
		
		return rep;
	}
	
	
}