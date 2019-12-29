package be.projet.dao;

import java.sql.Connection;
import java.util.List;

	abstract class DAO<T> {
	  final Connection connect;

	  DAO(Connection conn) {
	    this.connect = conn;
	  }

	  public abstract boolean create(T obj);

	  public abstract boolean delete(T obj);
 
	  public abstract boolean update(T obj);

	  //public abstract T find(int id);

	  public abstract List<T> getAll();
	}

