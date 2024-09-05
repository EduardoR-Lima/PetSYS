package petsys.database.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import petsys.database.ConnectionManager;
import petsys.database.models.Cliente;
import petsys.database.models.NotaFiscal;
import petsys.database.models.Venda;

public class VendaDao extends AbstractDao <Venda> {

	public VendaDao(ConnectionManager connManager) {
		super(connManager);
	}

	@Override
	protected Venda parseResult(ResultSet rs) throws SQLException, InterruptedException {
		Cliente cliente = new Cliente();
		cliente.setId(rs.getInt("id_cliente"));
		
		NotaFiscal notaFiscal = new NotaFiscal();
		notaFiscal.setId(rs.getInt("id_nf"));
		
		Venda venda = new Venda();
		venda.setId(rs.getInt("id"));
		venda.setDataVenda(rs.getString("data_venda"));
		venda.setFormaPagamento(rs.getString("forma_pag"));
		venda.setCliente(cliente);
		venda.setNf(notaFiscal);
		return venda;
	}

	@Override
	protected void mapMember(PreparedStatement stmt, Venda member) throws SQLException {
		stmt.setString(1, member.getDataVenda());
		stmt.setString(2, member.getFormaPagamento());
		stmt.setInt(3, member.getCliente().getId());	
		stmt.setInt(4, member.getNf().getId());
	}

	@Override
	protected String getCreationSQL() {
		return "INSERT INTO hist_vendas (data_venda, forma_pag, id_cliente, id_nf) VALUES (?, ?, ?, ?)";
	}

	@Override
	protected String getGeneralSQL() {
		return "SELECT id, data_venda, forma_pag, id_cliente, id_nf FROM hist_vendas";
	}

}
