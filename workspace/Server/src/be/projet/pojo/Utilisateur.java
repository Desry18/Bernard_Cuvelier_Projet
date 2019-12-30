package be.projet.pojo;

public class Utilisateur {
	
	private String pseudo;
	private String nom_util;
	private String mdp;
	private String email;
	private int id_util;
	
	public Utilisateur(String p, String nom, String motdp, String mail, int id2) {
		this.pseudo = p;
		this.nom_util = nom;
		this.mdp = motdp;
		this.email = mail;
		this.setId_util(id2);
	}
	
	public Utilisateur(String p, String nom, String motdp, String mail) {
		this.pseudo = p;
		this.nom_util = nom;
		this.mdp = motdp;
		this.email = mail;
	}
	
	public Utilisateur(String pseudo1) {
		// TODO Auto-generated constructor stub
		this.pseudo=pseudo1;
	}

	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getNom_util() {
		return nom_util;
	}
	public void setNom_util(String nom_util) {
		this.nom_util = nom_util;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getId_util() {
		return id_util;
	}

	public void setId_util(int id_util) {
		this.id_util = id_util;
	}
	

}
