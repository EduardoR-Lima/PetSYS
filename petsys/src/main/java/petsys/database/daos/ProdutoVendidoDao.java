package petsys.database.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import petsys.database.ConnectionManager;
import petsys.database.models.NotaFiscal;
import petsys.database.models.Produto;
import petsys.database.models.ProdutoVendido;

public class ProdutoVendidoDao extends AbstractDao <ProdutoVendido> {

	public ProdutoVendidoDao(ConnectionManager connManager) {
		super(connManager);
	}

	@Override
	protected ProdutoVendido parseResult(ResultSet rs) throws SQLException, InterruptedException {
		Produto produto = new Produto();
		produto.setId(rs.getInt("id"));
		
		NotaFiscal notaFiscal = new NotaFiscal();
		notaFiscal.setId(rs.getInt("id_nf"));
		
		ProdutoVendido produtoVendido = new ProdutoVendido();
		produtoVendido.setId(rs.getInt("id"));
		produtoVendido.setNf(notaFiscal);
		produtoVendido.setProduto(produto);
		produtoVendido.setQuantidade(rs.getInt("quant"));
		produtoVendido.setValorTotal(rs.getDouble("valor_total"));
		return produtoVendido;
	}

	@Override
	protected void mapMember(PreparedStatement stmt, ProdutoVendido member) throws SQLException {
		stmt.setInt(1, member.getNf().getId());	
		stmt.setInt(2, member.getProduto().getId());
		stmt.setInt(3, member.getQuantidade());
		stmt.setDouble(4, member.getValorTotal());	
	}

	@Override
	protected String getCreationSQL() {
		return "INSERT INTO hist_produtos_vendidos (id_nf, id_produto, quant, valor_total) VALUES (?, ?, ?, ?)";
	}

	@Override
	protected String getGeneralSQL() {
		return "SELECT id, id_nf, id_produto, quant, valor_total FROM hist_produtos_vendidos";
	}

}
