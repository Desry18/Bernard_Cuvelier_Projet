package be.projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.projet.pojo.Anime;
import be.projet.pojo.Manga;
import be.projet.pojo.Utilisateur;

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

	@Override
	public Manga find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Manga> find(String l) {
			// TODO Auto-generated method stub
			PreparedStatement statement = null;
		    ResultSet resultado = null;
	    	List<Manga> listeManga = new ArrayList<>();     
		    String query = "SELECT titre_manga, editeur_manga, nbr_tome, id_manga FROM manga WHERE titre_manga LIKE CONCAT(?, '%')";
		        try {
		            statement = connect.prepareStatement(query);	             
		            statement.setString(1, l);
		            resultado = statement.executeQuery(); 
		            while (resultado.next()) {
						String titre = resultado.getString(1);
						String edit = resultado.getString(2);
						int nbr_t = resultado.getInt(3);
						int id = resultado.getInt(4);
						
					    Manga ma = new Manga();
						ma.setId_manga(id);
						ma.setTitre_manga(titre);
						ma.setEdit_manga(edit);
						ma.setNbr_tome(nbr_t);
						listeManga.add(ma);
						

		            }		// TODO Auto-generated method stub
		        }
		        catch (SQLException e) {
					e.printStackTrace();
					
				}
		        finally {
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
	
	 public List<Manga> findall(int id){
		 return null;
	 }
	}