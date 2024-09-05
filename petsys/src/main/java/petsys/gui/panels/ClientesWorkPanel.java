package petsys.gui.panels;

import java.sql.SQLException;
import java.util.List;

import petsys.database.models.Cliente;
import petsys.database.services.ModelService;
import petsys.gui.Populateable.EntryHandler;
import petsys.gui.ResultFilter;

public class ClientesWorkPanel extends AbstractWorkSpacePanel<Cliente>{

	private ModelService<Cliente> service;
	
	public ClientesWorkPanel(ModelService<Cliente> service) {
		super("Clientes");
		this.service = service;
		
		ResultFilter<Cliente> cpfFilter = new ResultFilter<>("CPF");
		
		cpfFilter.setPopulateEntryHandler(e -> {
			return e.getCpf();
		});
		
		addFilters(List.of(cpfFilter));
	}

	@Override
	public String getCardId() {
		return "clientes_card";
	}

	@Override
	protected String[] getSearchKeys() {
		return new String[] {"CPF", "Nome"};
	}

	@Override
	protected EntryHandler<Cliente> getRsEntryHandler() {
		return new EntryHandler<Cliente>() {
			
			public String handle(Cliente model) {
				return "%s - %s - %s - %s".formatted(
						model.getNome(), model.getCpf(), model.getEndereco(), model.getEmail());
			}
		};
	}

	@Override
	protected SearchCallback<Cliente> getSearchCallback() {
		return new SearchCallback<Cliente>() {
			
			@Override
			public List<Cliente> getResultModels(String searchKey, String searchEntry) {
				try {
					if (searchEntry.isEmpty()) {
						return service.getAllMembers();
					}
					return service.getMembersByKey(searchKey, searchEntry);
				} catch (SQLException | InterruptedException e) {
					e.printStackTrace();
					return null;
				}
			}
		};
	}

}
