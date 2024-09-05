package petsys.database.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import petsys.database.ConnectionManager;
import petsys.database.models.Atendimento;
import petsys.database.models.Pet;
import petsys.database.models.Servico;
import petsys.database.models.Venda;
import petsys.database.models.Veterinario;

public class AtendimentoDao extends AbstractDao <Atendimento> {

	public AtendimentoDao(ConnectionManager connManager) {
		super(connManager);
	}

	@Override
	protected Atendimento parseResult(ResultSet rs) throws SQLException, InterruptedException {
		Servico servico = new Servico();
		servico.setId(rs.getInt("id"));
		
		Veterinario veterinario = new Veterinario();
		veterinario.setId(rs.getInt("id"));
		
		Pet pet = new Pet();
		pet.setId(rs.getInt("id"));
		
		Venda venda = new Venda();
		venda.setId(rs.getInt("id"));
		
		Atendimento atendimento = new Atendimento();
		atendimento.setId(rs.getInt("id"));
		atendimento.setDataAtendimento(rs.getString("data_atendimento"));
		atendimento.setMotivoAtendimento(rs.getString("motivo_atend"));
		atendimento.setServico(servico);
		atendimento.setVeterinario(veterinario);
		atendimento.setPet(pet);
		atendimento.setVenda(venda);
		return atendimento;
	}

	@Override
	protected void mapMember(PreparedStatement stmt, Atendimento member) throws SQLException {
		stmt.setString(1, member.getDataAtendimento());
		stmt.setString(2, member.getMotivoAtendimento());
		stmt.setInt(3, member.getServico().getId());
		stmt.setInt(4, member.getVeterinario().getId());
		stmt.setInt(5, member.getPet().getId());
		stmt.setInt(6, member.getVenda().getId());
	}

	@Override
	protected String getCreationSQL() {
		return "INSERT INTO hist_atendimentos (data_atendimento, motivo_atend, id_servico, id_veterinario, id_pet, id_venda) VALUES (?, ?, ?, ?, ?, ?)";
	}

	@Override
	protected String getGeneralSQL() {
		return "SELECT id, data_atendimento, motivo_atend, id_servico, id_veterinario, id_pet, id_venda FROM hist_atendimentos";
	}

}
