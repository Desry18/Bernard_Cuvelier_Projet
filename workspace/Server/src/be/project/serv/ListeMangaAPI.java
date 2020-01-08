package be.project.serv;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import be.projet.dao.ConnectDB;
import be.projet.dao.ListeMangaDAO;
import be.projet.pojo.ListeManga;

@Path("listeManga")
public class ListeMangaAPI extends RestApplication{
	private Response rep;
	private Connection conn;
	
	@Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllListeManga() {
		try {
			conn = ConnectDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rep = Response.status(Response.Status.OK).entity(new ListeMangaDAO(conn).getAll()).build();
		return rep;
		}

@Path("recupTitre")
@GET
@Produces(MediaType.APPLICATION_JSON)
public Response recupMangaByTitre(
	@QueryParam("id") int id) {
	
    try {
		conn = ConnectDB.getInstance().getConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	List<ListeManga> list = new ListeMangaDAO(conn).findall(id);
   
    if (list != null)
    	rep = Response .status(Response.Status.OK).entity(list).build();
    else
    	rep = Response .status(Response.Status.NO_CONTENT).entity(null).build();
    return rep;
}

@Path("getAllById/{id}")
@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getAllIDJson(@PathParam("id") int id) {

    try {
		conn = ConnectDB.getInstance().getConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	List<ListeManga> list = new ListeMangaDAO(conn).findall(id);
   
    if (list != null)
    	rep = Response .status(Response.Status.OK).entity(list).build();
    else
    	rep = Response .status(Response.Status.NO_CONTENT).entity(null).build();
    return rep;
}

@Path("nouvelListeM")
@POST
@Produces(MediaType.APPLICATION_JSON)
public Response nouvelListeM(
	@FormParam("id_manga") int im,
	@FormParam("id_util") int ia
	) {
		try {
			conn = ConnectDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ListeManga li = new ListeManga(im, ia);
		boolean ajout = new ListeMangaDAO(conn).create(li);
		if(ajout) rep = Response.status(Status.OK).build();
		else rep = Response.status(Response.Status.BAD_REQUEST).entity(li).build();	
		return rep;
	}


	@Path("delListM/{id_manga}/{id_util}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
public Response deletListe(
		@PathParam("id_manga") int im,
		@PathParam("id_util") int ia
		) {
			 try {
			conn = ConnectDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ListeManga li = new ListeManga(im, ia);
        boolean del = new ListeMangaDAO(conn).delete(li);
			if(del) rep = Response.status(Status.OK).build();
			else rep = Response.status(Response.Status.BAD_REQUEST).entity(li).build();	
			return rep;
		}
}
