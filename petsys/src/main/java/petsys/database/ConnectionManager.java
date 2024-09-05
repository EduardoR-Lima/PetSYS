package petsys.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionManager {
	public SafeConnection requestConnection() throws SQLException, InterruptedException;
	
	public void releaseConnection(Connection conn) throws SQLException;
}
