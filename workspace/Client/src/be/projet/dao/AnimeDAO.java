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

public class AnimeDAO extends DAO<Anime>{	
	public AnimeDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Anime> getAll() {
		String response =
        webResource.path("anime/getAll").accept(MediaType.APPLICATION_JSON).get(String.class);
    ObjectMapper mapper = new ObjectMapper();
    List<Anime> mag = new ArrayList<>();
    try {
      mag = mapper.readValue(response, new TypeReference<List<Anime>>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return mag;
		
	}

	@Override
	public boolean create(Anime g) {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		params.add("titre_anime", String.valueOf(g.getTitre_anime()));
		params.add("studio_anime", String.valueOf(g.getStudio_anime()));
		params.add("nbr_episode", String.valueOf(g.getNbr_episode()));
		params.add("date_sortie_anime", dateFormat.format(g.getDate_sortie_anime()));
		String response =
        webResource
            .path("anime/nouvelanime")
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
	public boolean delete(Anime g) {
		String response =
        webResource
            .path("anime/delanime?id=" + g.getId_anime())
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
	public boolean update(Anime g) {
	MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("nbr_episode", String.valueOf(g.getNbr_episode()));
		String response =
        webResource
            .path("anime/ChangerNbEp?id=" + g.getId_anime())
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
	public List<Anime> getAll(Anime obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Anime> findall(Manga i){
		String url = "anime/getAllById/"+i.getId_manga() ;

		 String response =
	        webResource.path(url).accept(MediaType.APPLICATION_JSON).get(String.class);
	    ObjectMapper mapper = new ObjectMapper();
	    List<Anime> util = new ArrayList<>();
	    try {
	      util = mapper.readValue(response, new TypeReference<List<Anime>>() {});
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return util;
		 }

	@Override
	public List<Anime> getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Anime> find(String i){

		 String response =
	        webResource.path("anime/recupAnimeByTitre"+"?"+"lettre="+i).accept(MediaType.APPLICATION_JSON).get(String.class);
	    ObjectMapper mapper = new ObjectMapper();
	    List<Anime> util = new ArrayList<>();
	    try {
	      util = mapper.readValue(response, new TypeReference<List<Anime>>() {});
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return util;
		 }

	@Override
	public Anime find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
