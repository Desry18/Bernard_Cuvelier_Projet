package be.projet.pojo;

import java.sql.Date;

public class Manga {
	private String titre_manga;
	private String edit_manga;
	private Date date_parution;
	private int nbr_tome;
	private int note_manga;
	
	public Manga() {}
	
	public Manga(String titre_manga, String editeur_manga, int nbr_tome2) {
		// TODO Auto-generated constructor stub
		this.titre_manga = titre_manga;
		this.edit_manga=editeur_manga;
		this.nbr_tome=nbr_tome2;
	}

	public String getTitre_manga() {
		return titre_manga;
	}
	public void setTitre_manga(String tritre_manga) {
		this.titre_manga = tritre_manga;
	}
	public String getEdit_manga() {
		return edit_manga;
	}
	public void setEdit_manga(String edit_manga) {
		this.edit_manga = edit_manga;
	}
	public Date getDate_parution() {
		return date_parution;
	}
	public void setDate_parution(Date date_parution) {
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
	
	
	

}
