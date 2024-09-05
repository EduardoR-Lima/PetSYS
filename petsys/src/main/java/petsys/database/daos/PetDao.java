package petsys.database.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import petsys.database.ConnectionManager;
import petsys.database.models.Cliente;
import petsys.database.models.Pet;

public class PetDao extends AbstractDao<Pet> {

	public PetDao(ConnectionManager connManager) {
		super(connManager);
	}

	@Override
	protected Pet parseResult(ResultSet rs) throws SQLException, InterruptedException {
		Cliente cliente = new Cliente();
		cliente.setId(rs.getInt("id_cliente"));
		
		Pet pet = new Pet();
		pet.setId(rs.getInt("id"));
		pet.setNome(rs.getString("nome"));
		pet.setDataNascimento(rs.getString("data_nascimento"));
		pet.setEspecie(rs.getString("especie"));
		pet.setRaca(rs.getString("raca"));
		pet.setSexo(rs.getString("sexo"));
		pet.setDono(cliente);
		pet.setDataAdicao(rs.getString("data_adicao"));
		return pet;
	}

	@Override
	protected void mapMember(PreparedStatement stmt, Pet member) throws SQLException {
		stmt.setString(1, member.getNome());
		stmt.setString(2, member.getDataNascimento());
		stmt.setString(3, member.getEspecie());
		stmt.setString(4, member.getRaca());
		stmt.setString(5, member.getSexo());
		stmt.setInt(6, member.getDono().getId());
		stmt.setString(7, member.getDataAdicao());
	}

	@Override
	protected String getCreationSQL() {
		return "INSERT INTO pets (nome, data_nascimento, especie, raca, sexo, id_cliente, data_adicao) VALUES (?, ?, ?, ?, ?, ?, ?)";
	}

	@Override
	protected String getGeneralSQL() {
		return "SELECT id, nome, data_nascimento, especie, raca, sexo, id_cliente, data_adicao FROM pets";
	}

}
