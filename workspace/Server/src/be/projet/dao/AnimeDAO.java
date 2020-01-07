package be.projet.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import be.projet.pojo.Anime;
import be.projet.pojo.Manga;
import be.projet.pojo.Utilisateur;

public class AnimeDAO extends DAO<Anime>{	
	public AnimeDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public List<Anime> getAll() {
		
		//Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String querry = "SELECT titre_anime, studio_anime, nbr_episode, id_anime, date_sortie_anime, note_anime FROM anime";
    	List<Anime> listeAnime = new ArrayList<>();       
        try {
            statement = connect.prepareStatement(querry);
            resultado = statement.executeQuery();
            
            
            while (resultado.next()) {
				String titre = resultado.getString(1);
				String stud = resultado.getString(2);
				int nbr_e = resultado.getInt(3);
				int id = resultado.getInt(4);	
				String date = resultado.getString(5);
				int note = resultado.getInt(6);
				
				listeAnime.add(new Anime(titre, stud, nbr_e, id, date, note));

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
		PreparedStatement stmt;
		String query = "insert into anime(id_anime,titre_anime,studio_anime, date_sortie_anime, nbr_episode,note_anime) values(anime_seq.NEXTVAL,?,?,?,?,?);" ;
		try {
		stmt = connect.prepareStatement(query);
		stmt.setString(1,obj.getTitre_anime());
        stmt.setString(2,obj.getStudio_anime());
        stmt.setString(3,obj.getDate_sortie_anime());
        stmt.setInt(4,obj.getNbr_episode());
        stmt.setInt(5,obj.getId_anime());
        stmt.execute();
        
        return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Anime g) {
		PreparedStatement stmt;
		String query = "Delete FROM anime where id_anime= ?" ;
		try {
		stmt = connect.prepareStatement(query);
		stmt.setInt(1,g.getId_anime());    
        stmt.execute();
        
        return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Anime obj) {
		CallableStatement statement = null;
		//String query = "UPDATE manga SET  nbr_tome = ? WHERE id_manga = ?";
		try {
			statement = connect.prepareCall("{? = call updateNbrEpisode(?,?)}");
			statement.setInt(1, obj.getId_anime());
			statement.setInt(2, obj.getNbr_episode());
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
	public Anime find(int id) {
		return null;
	}

	@Override
	public List<Anime> find(String l) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
	    ResultSet resultado = null;
	    List<Anime> listeAnime= new ArrayList<>();
	    String query = "SELECT titre_anime, studio_anime, nbr_episode, id_anime, date_sortie_anime, note_anime FROM anime WHERE titre_anime LIKE CONCAT(?, '%')";
	        try {
	            statement = connect.prepareStatement(query);	             
	            statement.setString(1, l);
	            resultado = statement.executeQuery(); 
	            while (resultado.next()) {
					String titre = resultado.getString(1);
					String studio = resultado.getString(2);
					int nbr_e = resultado.getInt(3);
					int id = resultado.getInt(4);
					String date = resultado.getString(5);
					int note = resultado.getInt(6);
					
					Anime an = new Anime();
					an.setId_anime(id);
					an.setTitre_anime(titre);
					an.setStudio_anime(studio);
					an.setNbr_episode(nbr_e);	
					an.setDate_sortie_anime(date);
					an.setNote_anime(note);
					listeAnime.add(an); 
					

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
		
		return listeAnime;
	}
	

	 public List<Anime> findAn(int ma){
		 PreparedStatement statement = null;
	        ResultSet resultado = null;
	        String query = "SELECT titre_anime, studio_anime, nbr_episode, date_sortie_anime, id_anime, note_anime FROM anime WHERE id_manga = ?";
	    	List<Anime> listanime = new ArrayList<>();       
	        try {
	            statement = connect.prepareStatement(query);
	            statement.setInt(1, ma);

	            resultado = statement.executeQuery();
	            
	            while (resultado.next()) {
					String titre = resultado.getString(1);
					String studio = resultado.getString(2);
					int nbr_e= resultado.getInt(3);
					String date = resultado.getString(4);	
					int id = resultado.getInt(5);
					int note = resultado.getInt(6);
					Anime m = new Anime();
					m.setTitre_anime(titre);
					m.setStudio_anime(studio);
					m.setNbr_episode(nbr_e);
					m.setDate_sortie_anime(date);
					m.setId_anime(id);
					m.setNote_anime(note);
					listanime.add(m);

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
			return listanime;
	 }

	@Override
	public List<Anime> findall(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	 }
