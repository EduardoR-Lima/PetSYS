package petsys.database.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import petsys.database.ConnectionManager;
import petsys.database.models.Cliente;

public class ClienteDao extends AbstractDao<Cliente> {

	public ClienteDao(ConnectionManager connManager) {
		super(connManager);
	}

	@Override
	protected Cliente parseResult(ResultSet rs) throws SQLException, InterruptedException {
		Cliente cliente = new Cliente();
		cliente.setId(rs.getInt("id"));
		cliente.setCpf(rs.getString("cpf"));
		cliente.setNome(rs.getString("nome"));
		cliente.setEndereco(rs.getString("endereco"));
		cliente.setTelefoneCel(rs.getString("tel_cel"));
		cliente.setEmail(rs.getString("email"));
		cliente.setDataAdicao(rs.getString("data_adicao"));
		return cliente;
	}

	@Override
	protected void mapMember(PreparedStatement stmt, Cliente member) throws SQLException {
		stmt.setString(1, member.getCpf());
		stmt.setString(2, member.getNome());
		stmt.setString(3, member.getEndereco());
		stmt.setString(4, member.getTelefoneCel());
		stmt.setString(5, member.getEmail());
		stmt.setString(6, member.getDataAdicao());
	}

	@Override
	protected String getCreationSQL() {
		return "INSERT INTO clientes (cpf, nome, endereco, tel_cel, email, data_adicao) VALUES (?, ?, ?, ?, ?, ?)";
	}

	@Override
	protected String getGeneralSQL() {
		return "SELECT id, cpf, nome, endereco, tel_cel, email, data_adicao FROM clientes";
	}

}
