package petsys.database.services;

import java.sql.SQLException;
import java.util.List;

import petsys.database.daos.Dao;
import petsys.database.models.Cliente;

public class ClienteService implements ModelService<Cliente>{
	
	private Dao<Cliente> dao;
	
	public ClienteService(Dao<Cliente> dao) {
		this.dao = dao;
	}

	@Override
	public void createMemeber(Cliente member) throws SQLException, InterruptedException {
		dao.createMemeber(member);
	}

	@Override
	public Cliente getMemberById(int id) throws SQLException, InterruptedException {
		return dao.getMemberById(id);
	}

	@Override
	public List<Cliente> getAllMembers() throws SQLException, InterruptedException {
		return dao.getAllMembers();
	}

	@Override
	public List<Cliente> getMembersByKey(String key, Object value) throws SQLException, InterruptedException {
		return dao.getMembersByKey(key, value);
	}

	@Override
	public void updateMember(Cliente memeber) throws SQLException, InterruptedException {
		dao.updateMember(memeber);
	}

	@Override
	public void deleteMemberById(int id) throws SQLException, InterruptedException {
		dao.deleteMemberById(id);
	}
	
}
