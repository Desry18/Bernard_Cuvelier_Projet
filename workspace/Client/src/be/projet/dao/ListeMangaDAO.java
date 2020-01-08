package be.projet.dao;

import be.projet.pojo.ListeManga;
import be.projet.pojo.Utilisateur;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ListeMangaDAO extends DAO<ListeManga> {
	public ListeMangaDAO()
	{
		super();
	}

	@Override
	public boolean delete(ListeManga g) {
		String response =
        webResource
            .path("listeManga/delListM/" + g.getId_manga()+"/"+g.getId_util() )
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

	public boolean create(ListeManga g) {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("id_manga", String.valueOf(g.getId_manga()));
		params.add("id_util", String.valueOf(g.getId_util()));
		String response =
        webResource
            .path("listeManga/nouvelListeM")
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

	public List<ListeManga> getById(int i) {
		String url = "listeManga/getAllById/"+i ;
		/*String urlf = null;
		try {
			urlf = URLDecoder.decode(url,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		String response =
        webResource.path(url).accept(MediaType.APPLICATION_JSON).get(String.class);
    ObjectMapper mapper = new ObjectMapper();
    List<ListeManga> mag = new ArrayList<>();
    try {
      mag = mapper.readValue(response, new TypeReference<List<ListeManga>>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return mag;
		
	}
	@Override
	public boolean update(ListeManga g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ListeManga> getAll() {
		
		String response =
		        webResource.path("listeManga/getAll").accept(MediaType.APPLICATION_JSON).get(String.class);
		    ObjectMapper mapper = new ObjectMapper();
		    List<ListeManga> lm = new ArrayList<>();
		    try {
		      lm = mapper.readValue(response, new TypeReference<List<ListeManga>>() {});
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    return lm;
				}
	

	@Override
	public List<ListeManga> getAll(ListeManga obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListeManga> find(String l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListeManga find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
