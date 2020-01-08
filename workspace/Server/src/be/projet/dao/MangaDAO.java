package be.projet.dao;

import java.sql.CallableStatement;
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
        String querry = "SELECT titre_manga, editeur_manga, nbr_tome, id_manga,date_parution, note_manga FROM manga";
    	List<Manga> listeManga = new ArrayList<>();       
        try {
            statement = connect.prepareStatement(querry);
            resultado = statement.executeQuery();
            
            
            while (resultado.next()) {
				String titre = resultado.getString(1);
				String edit = resultado.getString(2);
				int nbr_t = resultado.getInt(3);
				int id = resultado.getInt(4);
				String date = resultado.getString(5);
				int note = resultado.getInt(6);
				
				Manga m = new Manga();
				m.setTitre_manga(titre);
				m.setEdit_manga(edit);
				m.setNbr_tome(nbr_t);
				m.setId_manga(id);
				m.setDate_parution(date);
				m.setNote_manga(note);
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
		String query = "insert into manga(id_manga,titre_manga,editeur_manga, date_parution, nbr_tome,note_manga) values(manga_seq.NEXTVAL,?,?,?,?,?);" ;
		try {
		stmt = connect.prepareStatement(query);
		stmt.setString(1,obj.getTitre_manga());
        stmt.setString(2,obj.getEdit_manga());
        stmt.setString(3,obj.getDate_parution());
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
		PreparedStatement statement = null;
		String query = "UPDATE manga SET note_manga = note_manga+1 WHERE id_manga = ?";
		try {
			statement = connect.prepareStatement(query);
			statement.setInt(1, obj.getId_manga());
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
	public Manga find(int id) {
		 	PreparedStatement statement = null;
	        ResultSet resultado = null;
			Manga manga = new Manga();

	        String query = "SELECT titre_manga, editeur_manga, nbr_tome,date_parution,id_manga, note_manga FROM manga WHERE id_manga = ?";
	        try {
	            statement = connect.prepareStatement(query);	             
	            statement.setInt(1, id);
	            resultado = statement.executeQuery(); 
	            while (resultado.next()) {
					String titre = resultado.getString(1);
					String edit = resultado.getString(2);
					int nbr_t = resultado.getInt(3);
					String date = resultado.getString(4);
					int note = resultado.getInt(6);
					manga.setTitre_manga(titre);
					manga.setEdit_manga(edit);
					manga.setNbr_tome(nbr_t);
					manga.setDate_parution(date);
					manga.setId_manga(id);
					manga.setNote_manga(note);
				
					
					

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
			return manga;
	}

	@Override
	public List<Manga> find(String l) {
			// TODO Auto-generated method stub
			PreparedStatement statement = null;
		    ResultSet resultado = null;
	    	List<Manga> listeManga = new ArrayList<>();     
		    String query = "SELECT titre_manga, editeur_manga, nbr_tome, id_manga, date_parution, note_manga FROM manga WHERE titre_manga LIKE CONCAT(?, '%')";
		        try {
		            statement = connect.prepareStatement(query);	             
		            statement.setString(1, l);
		            resultado = statement.executeQuery(); 
		            while (resultado.next()) {
						String titre = resultado.getString(1);
						String edit = resultado.getString(2);
						int nbr_t = resultado.getInt(3);
						int id = resultado.getInt(4);
						String date = resultado.getString(5);
						int note = resultado.getInt(6);
					    Manga ma = new Manga();
						ma.setId_manga(id);
						ma.setTitre_manga(titre);
						ma.setEdit_manga(edit);
						ma.setNbr_tome(nbr_t);
						ma.setDate_parution(date);
						ma.setNote_manga(note);
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