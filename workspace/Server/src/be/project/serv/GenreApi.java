package be.project.serv;

import java.sql.Connection;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import be.projet.dao.ConnectDB;
import be.projet.dao.GenreDAO;


@Path("genre")
public class GenreApi {
	
	private Response rep;
	private Connection conn;
	
	@Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllGenreJson() {
		try {
			conn = ConnectDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rep = Response.status(Response.Status.OK).entity(new GenreDAO(conn).getAll()).build();
		return rep;
		}
	}


