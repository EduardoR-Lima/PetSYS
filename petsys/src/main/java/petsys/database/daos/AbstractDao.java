package petsys.database.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import petsys.database.ConnectionManager;
import petsys.database.SafeConnection;
import petsys.database.models.Model;

public abstract class AbstractDao<T extends Model> implements Dao<T> {

	protected ConnectionManager connManager;

	public AbstractDao(ConnectionManager connManager) {
		this.connManager = connManager;
	}

	abstract protected T parseResult(ResultSet rs) throws SQLException, InterruptedException;

	abstract protected void mapMember(PreparedStatement stmt, T member) throws SQLException;

	abstract protected String getCreationSQL();

	abstract protected String getGeneralSQL();

	@Override
	public void createMemeber(T member) throws SQLException, InterruptedException {
		try (SafeConnection sfConn = connManager.requestConnection()) {
			Connection conn = sfConn.retrieveConnection();

			String sql = getCreationSQL();
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				mapMember(stmt, member);
				stmt.executeUpdate();
			}
		}
	}

	@Override
	public T getMemberById(int id) throws SQLException, InterruptedException {
		T member = null;

		try (SafeConnection sfConn = connManager.requestConnection()) {
			Connection conn = sfConn.retrieveConnection();

			String sql = getGeneralSQL().concat(" WHERE id = ?");
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					member = parseResult(rs);
				}
			}
		}
		return member;
	}

	@Override
	public List<T> getAllMembers() throws SQLException, InterruptedException {
		List<T> members = new ArrayList<>();

		try (SafeConnection sfConn = connManager.requestConnection()) {
			Connection conn = sfConn.retrieveConnection();

			String sql = getGeneralSQL();
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					T member = parseResult(rs);
					members.add(member);
				}
			}
			return members;
		}
	}

	@Override
	public List<T> getMembersByKey(String key, Object value) throws SQLException, InterruptedException {
		List<T> members = new ArrayList<>();

		try (SafeConnection sfConn = connManager.requestConnection()) {
			Connection conn = sfConn.retrieveConnection();

			String sql = getGeneralSQL().concat(" WHERE %s = ?".formatted(key));
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setObject(1, value);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					T member = parseResult(rs);
					members.add(member);
				}
			}
			return members;
		}
	}

	@Override
	public void updateMember(T memeber) throws SQLException, InterruptedException {
	}

	@Override
	public void deleteMemberById(int id) throws SQLException, InterruptedException {
	}
	
	
}
