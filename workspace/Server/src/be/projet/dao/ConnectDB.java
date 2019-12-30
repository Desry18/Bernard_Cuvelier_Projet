package be.projet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	private static ConnectDB instance;
    private Connection connection;
    private String url = "jdbc:oracle:thin:@//char-oracle11.condorcet.be:1521/xe";
    private String username = "oceane";
    private String password = "Oceane";
    
    private ConnectDB() {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    public static ConnectDB getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectDB();
        } else if (instance.getConnection().isClosed()) {
            instance = new ConnectDB();
        }

        return instance;
    }
    
    public Connection getConnection() {
    	return connection;
    }
   }
