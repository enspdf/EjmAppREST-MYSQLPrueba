package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {

	Connection connection;

	public Connection getConnection() throws Exception {

		try {
			String connectionURL = "jdbc:mysql://localhost:3306/ws";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "");
			return connection;
		} catch (Exception e) {
			throw e;
		}

	}

	public void closeResources() throws SQLException {
		if (connection != null) {
			if (!connection.isClosed()) {
				connection.close();
			}
		}
	}

}
