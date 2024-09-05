package petsys.database.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import petsys.database.ConnectionManager;
import petsys.database.models.Produto;

public class ProdutoDao extends AbstractDao<Produto> {

	public ProdutoDao(ConnectionManager connManager) {
		super(connManager);
	}

	@Override
	protected Produto parseResult(ResultSet rs) throws SQLException, InterruptedException {
		Produto produto = new Produto();
		produto.setId(rs.getInt("id"));
		produto.setNome(rs.getString("nome"));
		produto.setCategoria(rs.getString("categoria"));
		produto.setEspecificacoes(rs.getString("especificacoes"));
		produto.setPreco(rs.getDouble("preco"));
		produto.setDataAdicao(rs.getString("data_adicao"));
		produto.setEstoque(rs.getInt("estoque"));		
		return produto;
	}

	@Override
	protected void mapMember(PreparedStatement stmt, Produto member) throws SQLException {
		stmt.setString(1, member.getNome());
		stmt.setString(2, member.getCategoria());
		stmt.setString(3, member.getEspecificacoes());
		stmt.setDouble(4, member.getPreco());
		stmt.setString(5, member.getDataAdicao());	
		stmt.setInt(6, member.getEstoque());
	}

	@Override
	protected String getCreationSQL() {
		return "INSERT INTO produtos (nome, categoria, especificacoes, preco, data_adicao, estoque) VALUES (?, ?, ?, ?, ?, ?, ?)";
	}

	@Override
	protected String getGeneralSQL() {
		return "SELECT id, nome, categoria, especificacoes, preco, data_adicao FROM produtos";
	}

}
