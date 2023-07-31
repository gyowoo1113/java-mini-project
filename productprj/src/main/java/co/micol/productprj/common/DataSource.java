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
	
	private DataSource() {

	}
	
	public static DataSource getInstance() {
		return instance;
	}
}
