package be.projet.dao;

//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import be.projet.pogo.Utilisateur;

public class UitilisateurDAO {
	
	
	public boolean create(Utilisateur util)	
	{
		
		String query = "insert into utilisateur(email, nom_util, pseudo, mdp) ";
		SingletonDB dbt = null;
		try {
			dbt = new SingletonDB();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = dbt.getConnection();
		PreparedStatement stmt;
		try {
		stmt = conn.prepareStatement(query);
		stmt.setString(1,util.getEmail());
        stmt.setString(2,util.getNom_util());
        stmt.setString(3,util.getPseudo());
        stmt.setString(4,util.getMdp());
        stmt.executeUpdate();
        return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
		
	}
}
