package be.projet.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class Anime {
	private String titre_anime;
	private String studio_anime;
	private Timestamp date_sortie_anime;
	private int nbr_episode;
	private int note_anime;
	private int id_anime;
	
	public Anime(String t_anime,String stud, int nbr_e, int id) {
		this.titre_anime = t_anime;
		this.studio_anime = stud;
		this.nbr_episode = nbr_e;
		this.id_anime = id;
		
	}
	
	public Anime() {
		// TODO Auto-generated constructor stub
	}

	public String getTitre_anime() {
		return titre_anime;
	}
	public void setTitre_anime(String tritre_anime) {
		this.titre_anime = tritre_anime;
	}
	public String getStudio_anime() {
		return studio_anime;
	}
	public void setStudio_anime(String studio_anime) {
		this.studio_anime = studio_anime;
	}
	public Timestamp getDate_sortie_anime() {
		return date_sortie_anime;
	}
	public void setDate_sortie_anime(Timestamp date) {
		this.date_sortie_anime = date;
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

	public int getId_anime() {
		return id_anime;
	}

	public void setId_anime(int id_anime) {
		this.id_anime = id_anime;
	}
	
	
}
