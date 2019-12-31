package be.projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.projet.pojo.ListManga;

public class ListMangaDAO  extends DAO<ListManga> {
	public ListMangaDAO(Connection conn)
	{
		super(conn);
	}
	
	@Override
	public boolean create(ListManga li)	
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
	public boolean delete(ListManga li) {
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
	public boolean update(ListManga g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ListManga> findall(int id) {
		
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String query = "SELECT Titre_manga FROM LISTEMANGA l INNER JOIN MANGA m ON l.ID_manga = m.ID_manga WHERE ID_util=?";
    	List<ListManga> listemanga = new ArrayList<>();       
        try {
            statement = connect.prepareStatement(query);
            resultado = statement.executeQuery();
            
            while (resultado.next()) {
				String lbl = resultado.getString(1);
				
				listemanga.add(new ListManga(lbl));

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
	public List<ListManga> find(String l) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ListManga find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListManga> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}


