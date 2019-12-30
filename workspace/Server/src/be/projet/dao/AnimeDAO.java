package be.projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.projet.pojo.Anime;
import be.projet.pojo.Manga;

public class AnimeDAO extends DAO<Anime>{	
	public AnimeDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public List<Anime> getAll() {
		
		//Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String querry = "SELECT titre_anime, studio_anime, nbr_episode, id_anime FROM anime";
    	List<Anime> listeAnime = new ArrayList<>();       
        try {
            statement = connect.prepareStatement(querry);
            resultado = statement.executeQuery();
            
            
            while (resultado.next()) {
				String titre = resultado.getString(1);
				String stud = resultado.getString(2);
				int nbr_e = resultado.getInt(3);
				int id = resultado.getInt(4);				
				
				listeAnime.add(new Anime(titre, stud, nbr_e, id));

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
		return listeAnime;
	}

	@Override
	public boolean create(Anime obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Anime obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Anime obj) {
		// TODO Auto-generated method stub
		return false;
	}
}