package petsys.database.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import petsys.database.ConnectionManager;
import petsys.database.models.NotaFiscal;

public class NotaFiscalDao extends AbstractDao<NotaFiscal> {

	public NotaFiscalDao(ConnectionManager connManager) {
		super(connManager);
	}

	@Override
	protected NotaFiscal parseResult(ResultSet rs) throws SQLException, InterruptedException {
		NotaFiscal notaFiscal = new NotaFiscal();
		notaFiscal.setId(rs.getInt("id"));
		notaFiscal.setTipo(rs.getString("tipo"));
		notaFiscal.setDataEmissao(rs.getString("data_emissao"));
		notaFiscal.setCpfCliente(rs.getString("cpf_cliente"));
		notaFiscal.setValorTotal(rs.getDouble("valor_nota"));
		return notaFiscal;
	}

	@Override
	protected void mapMember(PreparedStatement stmt, NotaFiscal member) throws SQLException {
		stmt.setString(1, member.getTipo());
		stmt.setString(2, member.getDataEmissao());
		stmt.setString(3, member.getCpfCliente());
		stmt.setDouble(4, member.getValorTotal());		
	}

	@Override
	protected String getCreationSQL() {
		return "INSERT INTO notas_fiscais (tipo, data_emissao, cpf_cliente, valor_nota) VALUES (?, ?, ?, ?)";
	}

	@Override
	protected String getGeneralSQL() {
		return "SELECT id, tipo, data_emissao, cpf_cliente, valor_nota FROM notas_fiscais";
	}

}
