package petsys.gui.panels;

import java.util.List;

import petsys.database.models.Cliente;
import petsys.database.models.NotaFiscal;
import petsys.database.models.Venda;
import petsys.gui.Populateable.EntryHandler;
import petsys.gui.ResultFilter;

public class VendasWorkPanel extends AbstractWorkSpacePanel<Venda> {

	public VendasWorkPanel() {
		super("Vendas");

		ResultFilter<Venda> dateFilter = new ResultFilter<>("data");
		dateFilter.setPopulateEntryHandler(e -> {
			return e.getDataVenda();
		});

		addFilters(List.of(dateFilter));
	}

	@Override
	public String getCardId() {
		return "vendas_card";
	}

	@Override
	protected String[] getSearchKeys() {
		return new String[] { "ID" };
	}

	@Override
	protected EntryHandler<Venda> getRsEntryHandler() {
		return new EntryHandler<Venda>() {

			@Override
			public String handle(Venda model) {
				return "%s - %s - %s".formatted(model.getDataVenda(), model.getCliente().getNome(),
						model.getFormaPagamento());
			}
		};
	}

	@Override
	protected SearchCallback<Venda> getSearchCallback() {
		return new SearchCallback<Venda>() {

			@Override
			public List<Venda> getResultModels(String searchKey, String searchEntry) {
				//Apenas para testes
				//Substituir pelo service responsável pelas vendas
				Venda venda = new Venda(1, "04092024", "Pix", new Cliente(), new NotaFiscal());
				Venda venda2 = new Venda(2, "05092024", "Cartão", new Cliente(), new NotaFiscal());
				return List.of(venda, venda, venda2, venda, venda);
			}
		};
	}

}
