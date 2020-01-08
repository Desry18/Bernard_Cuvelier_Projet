package be.projet.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import be.projet.pojo.Anime;
import be.projet.pojo.Manga;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class MangaDAO extends DAO<Manga>{	
	public MangaDAO() {
		super();
	}

	public List<Manga> getAll() {
		String response =
        webResource.path("manga/getAll").accept(MediaType.APPLICATION_JSON).get(String.class);
    ObjectMapper mapper = new ObjectMapper();
    List<Manga> mag = new ArrayList<>();
    try {
      mag = mapper.readValue(response, new TypeReference<List<Manga>>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return mag;
	}

	@Override
	public boolean create(Manga g) {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("titre_manga", String.valueOf(g.getTitre_manga()));
		params.add("edit_manga", String.valueOf(g.getEdit_manga()));
		params.add("date_parution",String.valueOf(g.getDate_parution()));
		params.add("nbr_tome",String.valueOf(g.getNbr_tome()));
		String response =
        webResource
            .path("manga/nouveauManga")
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

	@Override
	public boolean delete(Manga g) {
		String response =
        webResource
            .path("utilisateur/delmanga?id=" + g.getId_manga())
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

	@Override
	public boolean update(Manga g) {

		String response =
        webResource
            .path("manga/upDate/" + g.getId_manga())
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

	@Override
	public List<Manga> getAll(Manga obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Manga> getById(int i) {
		String url = "anime/getById/"+i;

		 String response =
	        webResource.path(url).accept(MediaType.APPLICATION_JSON).get(String.class);
	    ObjectMapper mapper = new ObjectMapper();
	    List<Manga> liste = new ArrayList<>();
	    try {
	      liste = mapper.readValue(response, new TypeReference<List<Manga>>() {});
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return liste;
		 
	}

	@Override
	public List<Manga> find(String l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manga find(int id) {
		String url = "manga/getById/"+id;

		 String response =
	        webResource.path(url).accept(MediaType.APPLICATION_JSON).get(String.class);
	    ObjectMapper mapper = new ObjectMapper();
	    Manga l = new Manga();
	    try {
	      l = mapper.readValue(response, new TypeReference<Manga>() {});
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return l;
	}
}
