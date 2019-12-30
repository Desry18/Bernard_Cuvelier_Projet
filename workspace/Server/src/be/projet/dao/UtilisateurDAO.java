package be.projet.dao;

import java.sql.CallableStatement;
//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.projet.pojo.Utilisateur;

public class UtilisateurDAO extends DAO<Utilisateur> {
	public UtilisateurDAO(Connection conn)
	{
		super(conn);
	}
	
	@Override
	public boolean create(Utilisateur util)	
	{
		
		String query = "insert into utilisateur(id, email, nom_util, pseudo, mdp) ";
		PreparedStatement stmt;
		try {
		stmt = connect.prepareStatement(query);
		
		stmt.setInt(1,util.getId());
		stmt.setString(2,util.getEmail());
        stmt.setString(3,util.getNom_util());
        stmt.setString(4,util.getPseudo());
        stmt.setString(5,util.getMdp());
        stmt.execute();
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
		CallableStatement statement = null;
		try {
			statement = connect.prepareCall("{call updatePseudo(?, ?}");
			statement.setInt(1, obj.getId());
			statement.setString(2, obj.getPseudo());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}			
			}
		}
		return true;
	}

	@Override
	public List<Utilisateur> getAll() {
		
		//Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String querry = "SELECT email, pseudo, nom_util, mdp FROM utilisateur";
    	List<Utilisateur> listeUtil = new ArrayList<>();       
        try {
            statement = connect.prepareStatement(querry);
            resultado = statement.executeQuery();
            
            
            while (resultado.next()) {
				String email = resultado.getString(1);
				String pseudo = resultado.getString(2);
				String mdp = resultado.getString(4);
				String nom = resultado.getString(3);
				
				listeUtil.add(new Utilisateur(pseudo, nom, mdp, email));

        }
        }
        catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if( resultado!= null) {
				try {
					resultado.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listeUtil;
	}
}