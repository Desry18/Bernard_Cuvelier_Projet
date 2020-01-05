package be.projet.dao;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import be.projet.pojo.Anime;

abstract class DAO<O> {
	  final WebResource webResource;

	DAO() {
  Client client = Client.create();
  webResource = client.resource("http://localhost:9090/Server/rest/");
	 }

	  public abstract boolean create(O obj);

	  public abstract boolean delete(O obj);

	  public abstract boolean update(O obj);

	  public abstract O find(int id);

	  public abstract List<O> getAll();
	  public abstract List<O> getAll(O obj);
	  public abstract List<O> getById(int i);
	  public abstract List<O> find(String l);
	}
