package be.projet.pogo;

public class Utilisateur {
	
	private String pseudo;
	private String nom_util;
	private String mdp;
	private String email;
	
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
	

}
