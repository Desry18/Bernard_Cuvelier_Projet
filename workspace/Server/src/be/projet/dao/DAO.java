package be.projet.dao;

import java.sql.Connection;
import java.util.List;

	abstract class DAO<O> {
	  final Connection connect;

	  DAO(Connection conn) {
	    this.connect = conn;
	  }

	  public abstract boolean create(O obj);

	  public abstract boolean delete(O obj);
 
	  public abstract boolean update(O obj);

	  //public abstract T find(int id);

	  public abstract List<O> getAll();
	  
	  public abstract O find(int id);
	  public abstract List<O> find(String l);
	  public abstract List<O> findall(int id);
	  

	}
