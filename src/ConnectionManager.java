import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Singleton - class that can be instantiated once
public class ConnectionManager {

	// instance of itself
	private static ConnectionManager instance = null;

	// DB credentials
	private static final String USERNAME = "root";
	private static final String PASSWORD = "3mvb1102";
	private static final String CONN_STRING = "jdbc:mysql://localhost/music";

	// connection object
	private Connection connection = null;

	// private constructor - can only be constructed from within this class
	private ConnectionManager() {

	}

	// check if instance is null, instantiate and return or return
	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	
	private boolean openConnection() {
		try {
			connection = DriverManager.getConnection(CONN_STRING, USERNAME,
					PASSWORD);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	public Connection getConnection() {
		if (connection == null) {
			if (openConnection()) {
				System.out.println("Connection opened");
				return connection;
			} else {
				return null;
			}
		}
		return connection;
	}

	public void close() {
		System.out.println("Closing connection");
		try {
			connection.close();
			connection = null;
		} catch (Exception e) {
		}
	}
}