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
		Veterinario veterinario = new Veterinario();
		veterinario.setId(rs.getInt("id"));
		veterinario.setCrmv(rs.getString("crmv"));
		veterinario.setNome(rs.getString("nome"));
		veterinario.setEndereco(rs.getString("endereco"));
		veterinario.setTelefoneCel(rs.getString("tel_cel"));
		veterinario.setEmail(rs.getString("email"));
		veterinario.setDataAdicao(rs.getString("data_adicao"));	
		return veterinario;
	}

	@Override
	protected void mapMember(PreparedStatement stmt, Veterinario member) throws SQLException {
		stmt.setString(1, member.getCrmv());
		stmt.setString(2, member.getNome());
		stmt.setString(3, member.getEndereco());
		stmt.setString(4, member.getTelefoneCel());
		stmt.setString(5, member.getEmail());
		stmt.setString(6, member.getDataAdicao());		
	}

	@Override
	protected String getCreationSQL() {
		return "INSERT INTO veterinarios (crmv, nome, endereco, tel_cel, email, data_adicao) VALUES (?, ?, ?, ?, ?, ?)";
	}

	@Override
	protected String getGeneralSQL() {
		return "SELECT id, crmv, nome, endereco, tel_cel, email, data_adicao FROM veterinarios";
	}

}
