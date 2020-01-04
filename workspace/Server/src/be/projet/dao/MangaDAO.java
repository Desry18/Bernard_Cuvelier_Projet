package be.projet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

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
        String querry = "SELECT titre_manga, editeur_manga, nbr_tome, id_manga,date_parution FROM manga";
    	List<Manga> listeManga = new ArrayList<>();       
        try {
            statement = connect.prepareStatement(querry);
            resultado = statement.executeQuery();
            
            
            while (resultado.next()) {
				String titre = resultado.getString(1);
				String edit = resultado.getString(2);
				int nbr_t = resultado.getInt(3);
				int id = resultado.getInt(4);
				Timestamp date = resultado.getTimestamp(5);
				
				Manga m = new Manga();
				m.setTitre_manga(titre);
				m.setEdit_manga(edit);
				m.setNbr_tome(nbr_t);
				m.setId_manga(id);
				m.setDate_parution(date);
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
		PreparedStatement stmt;
		String query = "insert into manga(titre_manga,editeur_manga, date_parution, nbr_tome,note_manga) values(?,?,?,?,?);" ;
		try {
		stmt = connect.prepareStatement(query);
		stmt.setString(1,obj.getTitre_manga());
        stmt.setString(2,obj.getEdit_manga());
        stmt.setDate(3,java.sql.Date.valueOf(
              obj.getDate_parution().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
        stmt.setInt(4,obj.getNbr_tome());
        stmt.setInt(5,obj.getNote_manga());
        stmt.execute();
        
        return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Manga g) {
		PreparedStatement stmt;
		String query = "Delete FROM manga where id_manga= ?" ;
		try {
		stmt = connect.prepareStatement(query);
		stmt.setInt(1,g.getId_manga());    
        stmt.execute();
        
        return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
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