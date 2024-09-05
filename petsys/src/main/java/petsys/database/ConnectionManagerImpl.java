package petsys.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.Semaphore;

public class ConnectionManagerImpl implements ConnectionManager {
	
	private Semaphore semaphore = new Semaphore(3, true);
	
	private String host_url;
	private String user;
	private String password;
	
	public ConnectionManagerImpl(String host_url, String user, String password) {
		this.host_url = host_url;
		this.user = user;
		this.password = password;
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(host_url, user, password);
	}
	
	@Override
	public SafeConnection requestConnection() throws SQLException, InterruptedException {
		semaphore.acquire();
		return new SafeConnectionImpl(getConnection());
	}
	
	@Override
	public void releaseConnection(Connection conn) throws SQLException {
		if (conn != null && !conn.isClosed()) conn.close();
		semaphore.release();
	}
	
	public class SafeConnectionImpl implements SafeConnection {
		
		private Connection conn;
		
		public SafeConnectionImpl(Connection conn) {
			this.conn = conn;
		}
		
		@Override
		public Connection retrieveConnection() {
			return conn;
		}
		
		@Override
		public void close() throws SQLException {
			releaseConnection(conn);
		}


		
	}
}
