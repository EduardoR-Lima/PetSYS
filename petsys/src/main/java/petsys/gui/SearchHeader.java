package petsys.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.MatteBorder;

import petsys.database.models.Model;

public class SearchHeader<T extends Model> implements CustomComponent<JPanel> {

	public static final Dimension DEFAULT_SIZE = new Dimension(0, 180);

	private boolean hasFilter;

	private JPanel basePanel;
	private BoxLayout baseLayout;
	private JLabel title;
	private SearchBar searchBar;
	private JButton searchButton;

	private JPanel titlePanel;
	private JPanel searchPanel;
	private JPanel filtersPanel;
	
	private List<ResultFilter<T>> filters;
	
	public SearchHeader() {
		this.hasFilter = false;

		basePanel = new JPanel();
		basePanel.setPreferredSize(DEFAULT_SIZE);

		basePanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));

		baseLayout = new BoxLayout(basePanel, BoxLayout.Y_AXIS);
		basePanel.setLayout(baseLayout);
		
		titlePanel = new JPanel(new SpringLayout());
		basePanel.add(titlePanel);
		
		searchPanel = new JPanel(new SpringLayout());
		basePanel.add(searchPanel);
		
		filtersPanel = new JPanel(new SpringLayout());
		basePanel.add(filtersPanel);

	}
	
	public SearchHeader(String titleText, String[] searchKeys) {
		this();
		addTitle(titleText);
		addSearchTool(searchKeys);
	}

	public void setTitleTextSize(int size) {
		Font currentFont = title.getFont();
		Font newFont = new Font(currentFont.getFamily(), currentFont.getStyle(), 35);
		title.setFont(newFont);
	}

	public void addTitle(String titleText) {
		title = new JLabel(titleText);
		setTitleTextSize(35);

		SpringLayout layout = (SpringLayout) titlePanel.getLayout();

		layout.putConstraint(SpringLayout.VERTICAL_CENTER, title, 0, SpringLayout.VERTICAL_CENTER, titlePanel);
		layout.putConstraint(SpringLayout.WEST, title, 30, SpringLayout.WEST, titlePanel);
		titlePanel.add(title);
	}

	public void addSearchTool(String[] searchKeys) {
		int leftPad = 50;
		int rightPad = -50;

		searchBar = new SearchBar(searchKeys);

		searchButton = new JButton("Pesquisar");
		searchButton.setPreferredSize(new Dimension(220, SearchBar.DEFAULT_SIZE.height));

		JPanel sbp = searchBar.getBaseComponent();
		SpringLayout layout = (SpringLayout) searchPanel.getLayout();

		layout.putConstraint(SpringLayout.VERTICAL_CENTER, searchButton, 0, SpringLayout.VERTICAL_CENTER, searchPanel);
		layout.putConstraint(SpringLayout.EAST, searchButton, rightPad, SpringLayout.EAST, searchPanel);
		searchPanel.add(searchButton);

		layout.putConstraint(SpringLayout.VERTICAL_CENTER, sbp, 0, SpringLayout.VERTICAL_CENTER, searchPanel);
		layout.putConstraint(SpringLayout.WEST, sbp, leftPad, SpringLayout.WEST, searchPanel);
		layout.putConstraint(SpringLayout.EAST, sbp, rightPad, SpringLayout.WEST, searchButton);
		searchPanel.add(sbp);
	}

	public void addFilters(List<ResultFilter<T>> filters) {
		this.hasFilter = true;
		this.filters = filters;
		int leftPad = 50;
		SpringLayout layout = (SpringLayout) filtersPanel.getLayout();

		JLabel label = new JLabel("Filtrar por:");
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, label, 0, SpringLayout.VERTICAL_CENTER, filtersPanel);
		layout.putConstraint(SpringLayout.WEST, label, leftPad, SpringLayout.WEST, filtersPanel);
		filtersPanel.add(label);

		for (int i = 0; i < filters.size(); i++) {
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, filters.get(i).getBaseComponent(), 0,
					SpringLayout.VERTICAL_CENTER, filtersPanel);
			if (i == 0) {
				layout.putConstraint(SpringLayout.WEST, filters.get(i).getBaseComponent(), 20, SpringLayout.EAST,
						label);
			} else {
				layout.putConstraint(SpringLayout.WEST, filters.get(i).getBaseComponent(), 20, SpringLayout.EAST,
						filters.get(i-1).getBaseComponent());
			}
			filtersPanel.add(filters.get(i).getBaseComponent());
		}

	}
	
	public void addSearchButtonListener(ActionListener listener) {
		searchButton.addActionListener(listener);
	}
	
	public String getCurrentSearchKey() {
		return searchBar.getSelectedSearchKey();
	}
	
	public String getCurrentSearch() {
		return searchBar.getSearch();
	}

	public boolean hasFilter() {
		return hasFilter;
	}
	
	public void clearCurrentSearchEntry() {
		searchBar.clearSearchText();
	}
	
	public void clearAllFilterItems() {
		Component[] comps = filtersPanel.getComponents();
		
		for (ResultFilter<T> filter : filters) {
			filter.clearItems();
		}
	}
	
	public void populateFilters(List<T> values) {
		for (ResultFilter<T> filter : filters) {
			filter.populate(values);
		}
	}

	@Override
	public JPanel getBaseComponent() {
		return basePanel;
	}

}
