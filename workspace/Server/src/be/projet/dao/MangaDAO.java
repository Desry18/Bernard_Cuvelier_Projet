package be.projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.projet.pojo.Manga;

public class MangaDAO extends DAO<Manga>{	
	public MangaDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public List<Manga> getAll() {
		
		//Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String querry = "SELECT titre_manga, editeur_manga, nbr_tome, id_manga FROM manga";
    	List<Manga> listeManga = new ArrayList<>();       
        try {
            statement = connect.prepareStatement(querry);
            resultado = statement.executeQuery();
            
            
            while (resultado.next()) {
				String titre = resultado.getString(1);
				String edit = resultado.getString(2);
				int nbr_t = resultado.getInt(3);
				int id = resultado.getInt(4);
				
				Manga m = new Manga();
				m.setTitre_manga(titre);
				m.setEdit_manga(edit);
				m.setNbr_tome(nbr_t);
				m.setId_manga(id);
				listeManga.add(m);

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
		return listeManga;
	}

	@Override
	public boolean create(Manga obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Manga obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Manga obj) {
		// TODO Auto-generated method stub
		return false;
	}
}