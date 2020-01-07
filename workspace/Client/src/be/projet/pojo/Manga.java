package be.projet.pojo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import be.projet.dao.AnimeDAO;
import be.projet.dao.MangaDAO;
import be.projet.dao.UtilisateurDAO;

/**
 * @author pc
 *
 */
public class Manga {

	private String titre_manga;
	private String edit_manga;	
	private String date_parution;	
	private int nbr_tome;	
	private int note_manga;
	private int id_manga;
	
	public String getTitre_manga() {
		return titre_manga;
	}
	public void setTitre_manga(String titre_manga) {
		this.titre_manga = titre_manga;
	}
	public String getEdit_manga() {
		return edit_manga;
	}
	public void setEdit_manga(String edit_manga) {
		this.edit_manga = edit_manga;
	}
	public String getDate_parution() {
		return date_parution;
	}
	public void setDate_parution(String date_parution) {
		this.date_parution = date_parution;
	}
	public int getNbr_tome() {
		return nbr_tome;
	}
	public void setNbr_tome(int nbr_tome) {
		this.nbr_tome = nbr_tome;
	}
	public int getNote_manga() {
		return note_manga;
	}
	public void setNote_manga(int note_manga) {
		this.note_manga = note_manga;
	}
	public int getId_manga() {
		return id_manga;
	}
	public void setId_manga(int id_manga) {
		this.id_manga = id_manga;
	}
	
	public List<Manga> searchAUser(String keyword) {
	    List<Manga> manga = new MangaDAO().getAll();
	    List<Manga> result = new ArrayList<>();
	    for (int i = 0; i < manga.size(); i++) {
	      if (manga.get(i).titre_manga.contains(keyword)) result.add(manga.get(i));
	    }
	    return result;
	  }
	
	public boolean createManga(String t, String e, int n, String d) {
		this.titre_manga=t;
		this.edit_manga=e;
		this.nbr_tome= n;
		this.date_parution=d;
	    return new MangaDAO().create(this);
	  }

	  public boolean deleteManga() {
	    return new MangaDAO().delete(this);
	  }
	  
	  public List<Manga> getAllManga()
	  {
		  
		  return new MangaDAO().getAll();
		  
	  }
	  
	  public boolean test() {
		  ListeManga l=new ListeManga();
		  return l.createMangalist();
	  }
	  
	  public List<Manga> getById(int i)
	  {
		  return new MangaDAO().getById(i);
	  }
	  
	  public List<Manga> trouverY(String keyword) {
		    List<Manga> m = new MangaDAO().getAll();
		    List<Manga> result = new ArrayList<>();
		    for (int i = 0; i < m.size(); i++) {
		      if (m.get(i).titre_manga.contains(keyword)) result.add(m.get(i));
		    }
		    return result;
		  }
	  public boolean addNote(int i) {
		    this.id_manga=i;
		    return new MangaDAO().update(this);
		  }
	  
}
