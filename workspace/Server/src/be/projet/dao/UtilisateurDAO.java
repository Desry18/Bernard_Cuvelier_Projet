package be.projet.dao;

//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import be.projet.pogo.Utilisateur;

public class UtilisateurDAO extends DAO<Utilisateur> {
	public UtilisateurDAO(Connection conn)
	{
		super(conn);
	}
	
	@Override
	public boolean create(Utilisateur util)	
	{
		
		String query = "insert into utilisateur(email, nom_util, pseudo, mdp) ";
		/*SingletonDB dbt = null;
		try {
			dbt = new SingletonDB();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = dbt.getConnection();
		*/
		PreparedStatement stmt;
		try {
		stmt = connect.prepareStatement(query);
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

	@Override
	public boolean delete(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Utilisateur> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
