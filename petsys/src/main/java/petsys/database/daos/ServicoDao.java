package petsys.database.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import petsys.database.ConnectionManager;
import petsys.database.models.Servico;

public class ServicoDao extends AbstractDao<Servico> {

	public ServicoDao(ConnectionManager connManager) {
		super(connManager);
	}

	@Override
	protected Servico parseResult(ResultSet rs) throws SQLException, InterruptedException {
		Servico servico = new Servico();
		servico.setId(rs.getInt("id"));
		servico.setNome(rs.getString("nome"));
		servico.setCategoria(rs.getString("categoria"));
		servico.setEspecificacoes(rs.getString("especificacoes"));
		servico.setValor(rs.getDouble("valor"));
		servico.setDataAdicao(rs.getString("data_adicao"));
		return servico;
	}

	@Override
	protected void mapMember(PreparedStatement stmt, Servico member) throws SQLException {
		stmt.setString(1, member.getNome());
		stmt.setString(2, member.getCategoria());
		stmt.setString(3, member.getEspecificacoes());
		stmt.setDouble(4, member.getValor());
		stmt.setString(5, member.getDataAdicao());		
	}

	@Override
	protected String getCreationSQL() {
		return "INSERT INTO servicos (nome, categoria, especificacoes, valor, data_adicao) VALUES (?, ?, ?, ?, ?)";
	}

	@Override
	protected String getGeneralSQL() {
		return "SELECT id, nome, categoria, especificacoes, valor, data_adicao FROM servicos";
	}

}
