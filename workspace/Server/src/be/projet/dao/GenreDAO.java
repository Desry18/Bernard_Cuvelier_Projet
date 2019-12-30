package be.projet.dao;

import java.sql.CallableStatement;
//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.projet.pogo.Genre;
import be.projet.pogo.Utilisateur;

public class GenreDAO extends DAO<Genre> {
	public GenreDAO(Connection conn)
	{
		super(conn);
	}
	
	@Override
	public boolean create(Genre g)	
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Genre g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Genre g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Genre> getAll() {
		
		//Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String querry = "SELECT libel_genre FROM genre";
    	List<Genre> listeGenre = new ArrayList<>();       
        try {
            statement = connect.prepareStatement(querry);
            resultado = statement.executeQuery();
            
            
            while (resultado.next()) {
				String lbl = resultado.getString(1);
				
				
				listeGenre.add(new Genre(lbl));

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
		return listeGenre;
	}
}
