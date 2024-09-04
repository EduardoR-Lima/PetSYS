package petsys.gui;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import petsys.database.models.AbstractSearchKey;
import petsys.database.models.Model;

public class Filters<T extends Model> implements CustomComponent<JPanel> {
	
	private JPanel basePanel;
	private FlowLayout baseLayout;
	
	/**
	 * Filtros funcionam em cima dos resultados da ultima pesquisa, portanto devem
	 * ser formulados em termos de SearchKeys, para conseguirem capturar os items
	 * adequados
	 */
	public Filters(AbstractSearchKey<T> searchKeys) {
		baseLayout = new FlowLayout();
		basePanel = new JPanel(baseLayout);
		
		
	}
	
	@Override
	public JPanel getBaseComponent() {
		return basePanel;
	}

}
