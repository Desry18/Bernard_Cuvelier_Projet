package be.projet.pojo;

import java.util.List;

import be.projet.dao.MangaDAO;
import be.projet.dao.UtilisateurDAO;

public class Utilisateur {
	private String pseudo;
	private String nom_util;
	private String mdp;
	private String email;
	private int id_util;
	
	
	
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
	
	public boolean log(String pseudo, String mdp) {
	    List<Utilisateur> util = new UtilisateurDAO().getAll();
	    for (int i = 0; i < util.size(); i++) {
	      if (util.get(i).getPseudo().equals(pseudo)) {
	        if (util.get(i).getMdp().equals(mdp)) {
	          this.pseudo = util.get(i).getPseudo();
	          this.mdp = util.get(i).getMdp();
	          this.id_util = util.get(i).getId_util();
	          this.nom_util = util.get(i).getNom_util();
	          this.email= util.get(i).getEmail();
	          return true;
	        }
	      }
	    }
	    return false;
	  }
	
	 public boolean enregistrer(
		      String email,
		      String nom,
		      String pseudo,
		      String mdp) {
		    this.email = email;
		    this.nom_util = nom;
		    this.pseudo = pseudo;
		    this.mdp = mdp;
		    return new UtilisateurDAO().create(this);
		  }
	 public List<Utilisateur> getAllUtil()
	  {
		  
		  List<Utilisateur> list = new UtilisateurDAO().getAll();
		  return list;
	  }
	 
	 public List<Manga> getAll()
	  {
		  
		 return new MangaDAO().getAll();
	  }
	 public boolean ajouterAMaList(int i) {
		Manga m= new MangaDAO().find(i);
		return m.test();
	 }

}
