package be.projet.pojo;

public class Genre {
	private String libel_genre;
	private int id_genre;
	
	public Genre() {}
	public Genre(String lg, int id) {
		this.libel_genre= lg;
		this.id_genre = id;
	}

	public String getLibel_genre() {
		return libel_genre;
	}

	public void setLibel_genre(String libel_genre) {
		this.libel_genre = libel_genre;
	}
	public int getId_genre() {
		return id_genre;
	}
	public void setId_genre(int id_genre) {
		this.id_genre = id_genre;
	}
	

}
