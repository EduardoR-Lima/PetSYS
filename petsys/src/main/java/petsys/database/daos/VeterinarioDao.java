package petsys.database.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import petsys.database.ConnectionManager;
import petsys.database.models.Veterinario;

public class VeterinarioDao extends AbstractDao<Veterinario>{

	public VeterinarioDao(ConnectionManager connManager) {
		super(connManager);
	}

	@Override
	protected Veterinario parseResult(ResultSet rs) throws SQLException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void mapMember(PreparedStatement stmt, Veterinario member) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getCreationSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getGeneralSQL() {
		// TODO Auto-generated method stub
		return null;
	}

}
