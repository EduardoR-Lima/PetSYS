package petsys.gui;

import petsys.database.models.Cliente;
import petsys.database.models.NotaFiscal;
import petsys.database.models.Venda;

public class VendasWorkPanel extends AbstractWorkSpacePanel<Venda>{

	public VendasWorkPanel() {
		super("Vendas");
		
		setRsEntryHandler(e -> {
			return "%s - %s - %s".formatted(e.getDataVenda(), e.getCliente(), e.getFormaPagamento());
		});
		
		addSearchTool(new String[]{"ID"});
		addSearchCallback((k, s) -> {
			Venda venda = new Venda(1, "04092024", "Pix", new Cliente(), new NotaFiscal());
			return new Venda[] {venda, venda, venda, venda, venda};
		});
	}

	@Override
	public String getCardId() {
		return "vendas_card";
	}

}
