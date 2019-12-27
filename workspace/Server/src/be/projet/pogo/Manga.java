package be.projet.pogo;

import java.sql.Date;

public class Manga {
	private String tritre_manga;
	private String edit_manga;
	private Date date_parution;
	private int nbr_tome;
	private int note_manga;
	
	public Manga() {}
	
	public String getTritre_manga() {
		return tritre_manga;
	}
	public void setTritre_manga(String tritre_manga) {
		this.tritre_manga = tritre_manga;
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
