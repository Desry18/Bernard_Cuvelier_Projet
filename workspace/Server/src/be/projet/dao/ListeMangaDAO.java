package be.projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.projet.pojo.ListeManga;
import be.projet.pojo.Utilisateur;

public class ListeMangaDAO  extends DAO<ListeManga> {
	public ListeMangaDAO(Connection conn)
	{
		super(conn);
	}
	
	@Override
	public boolean create(ListeManga li)	
	{
		PreparedStatement stmt;
		String query = "INSERT INTO listmanga (id_manga,ID_util) VALUES (?, ? )" ;
		try {
		stmt = connect.prepareStatement(query);
		stmt.setInt(1,li.getId_manga());
        stmt.setInt(2,li.getId_util());
     
        stmt.execute();
        
        return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(ListeManga li) {
		PreparedStatement stmt;
		String query = "Delete FROM listmanga where id_manga= ? AND id_util=?" ;
		try {
		stmt = connect.prepareStatement(query);
		stmt.setInt(1,li.getId_manga());
        stmt.setInt(2,li.getId_util());
     
        stmt.execute();
        
        return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(ListeManga g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ListeManga> findall(int id) {
		
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String query = "SELECT titre_manga, l.id_manga, l.id_util FROM listemanga l INNER JOIN  manga m ON l.ID_manga = m.ID_manga INNER JOIN utilisateur u ON l.id_util= u.id_util WHERE l.ID_util=?";
    	List<ListeManga> listemanga = new ArrayList<>();       
        try {
            statement = connect.prepareStatement(query);
            statement.setInt(1, id);
            resultado = statement.executeQuery();
            while (resultado.next()) {
				String lbl = resultado.getString(1);
				int id_m = resultado.getInt(2);				
				listemanga.add(new ListeManga(lbl,id_m, id));

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
		return listemanga;
	}
	
	@Override
	public List<ListeManga> find(String l) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ListeManga find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListeManga> getAll() {		
	        PreparedStatement statement = null;
	        ResultSet resultado = null;
	        String querry = "SELECT id_manga, id_util FROM listemanga";
	    	List<ListeManga> listeManga = new ArrayList<>();       
	        try {
	            statement = connect.prepareStatement(querry);
	            resultado = statement.executeQuery();
	            
	            
	            while (resultado.next()) {
					int id = resultado.getInt(1);
					int id2 = resultado.getInt(2);
					
					listeManga.add(new ListeManga(id, id2));

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
		// TODO Auto-generated method stub
}


