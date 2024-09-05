package petsys.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface SafeConnection extends AutoCloseable {
	
	public Connection retrieveConnection();
	
	public void close() throws SQLException;
	
}
