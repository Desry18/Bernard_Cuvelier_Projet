package be.projet.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import be.projet.pojo.Utilisateur;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UtilisateurDAO extends DAO<Utilisateur> {
	public UtilisateurDAO()
	{
		super();
	}
	
	@Override
	public boolean create(Utilisateur g)	
	{
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("email", String.valueOf(g.getEmail()));
		params.add("nom_util", String.valueOf(g.getNom_util()));
		params.add("pseudo", String.valueOf(g.getPseudo()));
		params.add("mdp", String.valueOf(g.getMdp()));
		String response =
        webResource
            .path("utilisateur/nouvelUtilisateur")
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
	public boolean delete(Utilisateur g) {
		String response =
        webResource
            .path("utilisateur/suppUtil?id=" + g.getId_util())
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
	public boolean update(Utilisateur g) {

		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("pseudo", String.valueOf(g.getPseudo()));

		String response =
        webResource
            .path("utilisateur/changerPseudo?id=" + g.getId_util())
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
	public List<Utilisateur> getAll() {
		String response =
        webResource.path("utilisateur/getAll").accept(MediaType.APPLICATION_JSON).get(String.class);
    ObjectMapper mapper = new ObjectMapper();
    List<Utilisateur> util = new ArrayList<>();
    try {
      util = mapper.readValue(response, new TypeReference<List<Utilisateur>>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return util;
		}

	@Override
	public List<Utilisateur> getAll(Utilisateur obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
