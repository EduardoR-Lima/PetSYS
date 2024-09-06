package petsys.gui.panels;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

import petsys.database.models.Model;
import petsys.gui.CardComponent;
import petsys.gui.Populateable.EntryHandler;
import petsys.gui.ResultFilter;
import petsys.gui.ResultSpace;
import petsys.gui.SearchHeader;

public abstract class AbstractWorkSpacePanel<T extends Model> implements CardComponent<JPanel> {

	private List<T> lastResult;
	private JPanel basePanel;
	private SearchHeader<T> sh;
	private ResultSpace<T> rs;

	public AbstractWorkSpacePanel(String title) {
		SpringLayout layout = new SpringLayout();
		basePanel = new JPanel(layout);
		sh = new SearchHeader<>();
		sh.addTitle(title);
		sh.addSearchTool(getSearchKeys());
		sh.addSearchButtonListener(e -> {
			Thread thread = new Thread(() -> {
				String searchKey = sh.getCurrentSearchKey();
				String searchEntry = sh.getCurrentSearch();

				List<T> resultModels = getSearchCallback().getResultModels(searchKey, searchEntry);

				SwingUtilities.invokeLater(() -> {
					lastResult = resultModels;
					rs.clearSpace();
					if (sh.hasFilter()) {
						sh.clearAllFilterItems();
						sh.populateFilters(resultModels);
					}
					rs.populate(resultModels);

					basePanel.updateUI();
				});
				
				if (resultModels.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Não foi possível encontrar nenhum dado referente a sua pesquisa:"
							+ "\n\tEntrada: \"%s\"\n\tPesquisa via: \"%s\""
									.formatted(searchEntry, searchKey),
							"Dados não encontrados", JOptionPane.WARNING_MESSAGE);
					sh.clearCurrentSearchEntry();
				}
			});
			
			thread.start();
		});

		rs = new ResultSpace<>();
		rs.setHasVisualizeButton(false);
		rs.setPopulateEntryHandler(getRsEntryHandler());

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
		
		basePanel.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
			}
			
			@Override
			public void componentResized(ComponentEvent e) {	
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				lastResult = null;
				rs.clearSpace();
				if (sh.hasFilter()) {
					sh.clearAllFilterItems();
				}
			}
		});
	}

	protected abstract String[] getSearchKeys();

	protected abstract EntryHandler<T> getRsEntryHandler();

	protected abstract SearchCallback<T> getSearchCallback();

	private void repopulateRs(List<T> models) {
		rs.clearSpace();
		rs.populate(models);
		basePanel.updateUI();
	}

	public void addFilters(List<ResultFilter<T>> filters) {

		for (ResultFilter<T> filter : filters) {
			filter.setSelectionCallBack(e -> {
				if (lastResult == null) return;
				
				if (e == null) {
					repopulateRs(lastResult);
					return;
				}
				List<T> filteredResult = new LinkedList<>();
				for (T model : lastResult) {
					if (filter.applyEntryHandler(model).equals(e)) {
						filteredResult.addLast(model);
					}
				}
				repopulateRs(filteredResult);
			});
		}

		sh.addFilters(filters);
	}

	protected List<T> getLastResult() {
		return lastResult;
	}

	@Override
	public JPanel getBaseComponent() {
		return basePanel;
	}

	protected interface SearchCallback<T> {
		public List<T> getResultModels(String searchKey, String searchEntry);
	}
}
