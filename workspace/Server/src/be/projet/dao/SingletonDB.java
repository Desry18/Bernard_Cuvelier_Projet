package be.projet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonDB {
	
	private static SingletonDB instance;
    private Connection connection;
    private String url = "jdbc:oracle:thin:@//char-oracle11.condorcet.be:1521/xe";
    private String username = "oceane";
    private String password = "Oceane";
    
    public Connection getConnection() {
        return connection;
    }
    
    public SingletonDB() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }catch (SQLException e) {
			e.printStackTrace();
		}
    }

  

    public static SingletonDB getInstance() throws SQLException {
        if (instance == null) {
            instance = new SingletonDB();
        } else if (instance.getConnection().isClosed()) {
            instance = new SingletonDB();
        }

        return instance;
    }
}
