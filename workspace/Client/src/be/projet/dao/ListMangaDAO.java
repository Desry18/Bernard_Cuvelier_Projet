package be.projet.dao;

import be.projet.pojo.ListManga;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListMangaDAO extends DAO<ListManga> {
	public ListMangaDAO()
	{
		super();
	}

	@Override
	public boolean delete(ListManga g) {
		String response =
        webResource
            .path("listmanga/suppListManga?id_manga=" + g.getId_manga()+"?id_util="+g.getId_util() )
            .accept(MediaType.APPLICATION_JSON)
            .delete(String.class);
    ObjectMapper mapper = new ObjectMapper();
    Boolean done = false;
    try {
      done = mapper.readValue(response, new TypeReference<Boolean>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return done;
	}

	public boolean create(ListManga g) {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("id_manga", String.valueOf(g.getId_manga()));
		params.add("id_util", String.valueOf(g.getId_util()));
		String response =
        webResource
            .path("listmanga/createlistmanga")
            .accept(MediaType.APPLICATION_JSON)
            .type("application/x-www-form-urlencoded")
            .post(String.class, params);
    ObjectMapper mapper = new ObjectMapper();
    Boolean done = false;
    try {
      done = mapper.readValue(response, new TypeReference<Boolean>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return done;
	}

	public List<ListManga> getAll(ListManga g) {
		String response =
        webResource.path("listmanga/getAll?id_util"+g.getId_util()).accept(MediaType.APPLICATION_JSON).get(String.class);
    ObjectMapper mapper = new ObjectMapper();
    List<ListManga> mag = new ArrayList<>();
    try {
      mag = mapper.readValue(response, new TypeReference<List<ListManga>>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return mag;
		
	}
	@Override
	public boolean update(ListManga g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ListManga> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
