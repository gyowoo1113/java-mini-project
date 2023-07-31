package co.micol.productprj.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	private static DataSource instance = new DataSource();
	private Connection connection = null;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private DataSource() {
		getProperties();
	
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void getProperties() {
		String resource = "/database.properties";
		Properties properties = new Properties();
		
		try {
			InputStream reader = getClass().getResourceAsStream(resource);
			properties.load(reader);
			
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getInstance() {
		return instance;
	}
	
	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
