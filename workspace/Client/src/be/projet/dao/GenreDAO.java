package be.projet.dao;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import be.projet.pojo.Genre;

public class GenreDAO extends DAO<Genre> {

  	public GenreDAO() {
    	super();
  	}

	
	@Override
	public boolean create(Genre g)	
	{
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("libel_genre", String.valueOf(g.getLibel_genre()));
		String response =
        webResource
            .path("genre/CreateGenre")
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
	public boolean delete(Genre g) {
		String response =
        webResource
            .path("genre/DeleteGenre?id=" + g.getId_genre())
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
	public boolean update(Genre g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Genre> getAll() {

	String response =
        webResource.path("genre/getAll").accept(MediaType.APPLICATION_JSON).get(String.class);
    ObjectMapper mapper = new ObjectMapper();
    List<Genre> genre = new ArrayList<>();
    try {
      genre = mapper.readValue(response, new TypeReference<List<Genre>>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return genre;
			
	}


	@Override
	public List<Genre> getAll(Genre obj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Genre> getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Genre> find(String l) {
		// TODO Auto-generated method stub
		return null;
	}}
