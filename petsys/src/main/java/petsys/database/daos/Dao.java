package petsys.database.daos;

import java.sql.SQLException;
import java.util.List;

import petsys.database.models.Model;

public interface Dao<T extends Model> {
	void createMemeber(T member) throws SQLException, InterruptedException;
	T getMemberById(int id) throws SQLException, InterruptedException;
	List<T> getAllMembers() throws SQLException, InterruptedException;
	List<T> getMembersByKey(String key, Object value) throws SQLException, InterruptedException;
	void updateMember(T memeber) throws SQLException, InterruptedException;
	void deleteMemberById(int id) throws SQLException, InterruptedException;
}
