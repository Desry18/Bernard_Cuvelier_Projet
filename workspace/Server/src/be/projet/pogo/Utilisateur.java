package be.projet.pogo;

public class Utilisateur {
	
	private String pseudo;
	private String nom_util;
	private String mdp;
	private String email;
	
	public Utilisateur() {}
	
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
