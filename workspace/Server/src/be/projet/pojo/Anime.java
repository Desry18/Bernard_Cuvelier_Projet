package be.projet.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class Anime {
	private String titre_anime;
	private String studio_anime;
	private String date_sortie_anime;
	private int nbr_episode;
	private int note_anime;
	private int id_anime;
	private int id_manga;
	
	public int getId_manga() {
		return id_manga;
	}

	public void setId_manga(int id_manga) {
		this.id_manga = id_manga;
	}

	public Anime(String titre, String stud, int nbr_e, int id, String date, int note) {
		this.titre_anime = titre;
		this.studio_anime = stud;
		this.nbr_episode = nbr_e;
		this.id_anime = id;
		this.date_sortie_anime = date;
		this.note_anime = note;
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
	public String getDate_sortie_anime() {
		return date_sortie_anime;
	}
	public void setDate_sortie_anime(String date) {
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
