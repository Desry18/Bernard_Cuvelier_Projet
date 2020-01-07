package be.projet.pojo;

import java.util.List;

import be.projet.dao.ListeMangaDAO;

public class ListeManga {
	private int id_manga;
	private int id_util;
	private String titre_manga;
	
	public ListeManga(int id_m, int id_u) {
		this.id_manga=id_m;
		this.id_manga=id_u;
	}
	
	public ListeManga() {}
	
	public ListeManga(String ti) {
		this.titre_manga=ti;
	}
	
	public int getId_manga() {
		return id_manga;
	}
	public void setId_manga(int id_manga) {
		this.id_manga = id_manga;
	}
	public int getId_util() {
		return id_util;
	}
	public void setId_util(int id_util) {
		this.id_util = id_util;
	}
	public String getTitre_manga() {
		return titre_manga;
	}
	public void setTitre_manga(String titre_manga) {
		this.titre_manga = titre_manga;
	}
	
	public boolean createMangalist() {
	    return new ListeMangaDAO().create(this);
	  }
	
	public boolean deleteMangalist() {
	    return new ListeMangaDAO().delete(this);
	  }
	
	
	public List<ListeManga> getAllListeManga()
	{
		return new ListeMangaDAO().getAll();
	}
}
