package be.projet.pogo;

import java.sql.Date;

public class Anime {
	private String tritre_anime;
	private String studio_anime;
	private Date date_sortie_anime;
	private int nbr_episode;
	private int note_anime;
	
	public Anime() {}
	
	public String getTritre_anime() {
		return tritre_anime;
	}
	public void setTritre_anime(String tritre_anime) {
		this.tritre_anime = tritre_anime;
	}
	public String getStudio_anime() {
		return studio_anime;
	}
	public void setStudio_anime(String studio_anime) {
		this.studio_anime = studio_anime;
	}
	public Date getDate_sortie_anime() {
		return date_sortie_anime;
	}
	public void setDate_sortie_anime(Date date_sortie_anime) {
		this.date_sortie_anime = date_sortie_anime;
	}
	public int getNbr_episode() {
		return nbr_episode;
	}
	public void setNbr_episode(int nbr_episode) {
		this.nbr_episode = nbr_episode;
	}
	public int getNote_anime() {
		return note_anime;
	}
	public void setNote_anime(int note_anime) {
		this.note_anime = note_anime;
	}
	
	
}
