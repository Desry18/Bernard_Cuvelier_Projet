package be.projet.pojo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import be.projet.dao.AnimeDAO;
import be.projet.dao.MangaDAO;

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
	
	public boolean createManga() {
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
}
