package petsys.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

import petsys.database.models.Model;
import petsys.gui.Populateable.EntryHandler;

public abstract class AbstractWorkSpacePanel<T extends Model> implements CardComponent<JPanel> {
	
	protected JPanel basePanel;
	protected SearchHeader<T> sh;
	protected ResultSpace<T> rs;
	
	public AbstractWorkSpacePanel(String title) {
		SpringLayout layout = new SpringLayout();
		basePanel = new JPanel(layout);
		sh = new SearchHeader<>();
		sh.addTitle(title);
		
		rs = new ResultSpace<>();
		rs.setHasVisualizeButton(false);
		
		JPanel base = sh.getBaseComponent();

		layout.putConstraint(SpringLayout.EAST, base, 0, SpringLayout.EAST, basePanel);
		layout.putConstraint(SpringLayout.WEST, base, 0, SpringLayout.WEST, basePanel);
		layout.putConstraint(SpringLayout.NORTH, base, 20, SpringLayout.NORTH, basePanel);

		basePanel.add(base);
		
		JScrollPane base2 = rs.getBaseComponent();
		
		layout.putConstraint(SpringLayout.NORTH, base2, 0, SpringLayout.SOUTH, base);
		layout.putConstraint(SpringLayout.SOUTH, base2, 0, SpringLayout.SOUTH, basePanel);
		layout.putConstraint(SpringLayout.EAST, base2, 0, SpringLayout.EAST, basePanel);
		layout.putConstraint(SpringLayout.WEST, base2, 0, SpringLayout.WEST, basePanel);
		
		basePanel.add(base2);
	}
	
	public void addSearchTool(String[] searchKeys) {
		sh.addSearchTool(searchKeys);
	}
	
	public void addFilters(ResultFilter<T>[] filters) {
		sh.addFilters(filters);
	}
	
	public void setRsEntryHandler(EntryHandler<T> handler) {
		rs.setPopulateEntryHandler(handler);
	}
	
	public void addSearchCallback(SearchCallback<T> callback) {
		sh.addSearchButtonListener(e -> {
			String searchKey = sh.getCurrentSearchKey();
			String searchEntry = sh.getCurrentSearch();
			
			T[] resultModels = callback.getReasultModels(searchKey, searchEntry);
			rs.clearSpace();
			sh.clearCurrentSearchEntry();
			if (sh.hasFilter()) {
				sh.clearAllFilterItems();
				sh.populateFilters(resultModels);
			}
			rs.populate(resultModels);
			
			basePanel.updateUI();
			
		});
	}
	
	@Override
	public JPanel getBaseComponent() {
		return basePanel;
	}
	
	public interface SearchCallback<T> {
		public T[] getReasultModels(String searchKey, String searchEntry);
	}
}
