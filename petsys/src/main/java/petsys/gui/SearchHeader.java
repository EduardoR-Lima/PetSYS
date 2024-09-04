package petsys.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.MatteBorder;

import petsys.database.models.AbstractSearchKey;
import petsys.database.models.Model;

public class SearchHeader<T extends Model> implements CustomComponent<JPanel> {
	
	public static final Dimension DEFAULT_SIZE = new Dimension(0, 180);
	
	private boolean hasFilter;
	
	private JPanel basePanel;
	private BoxLayout baseLayout;
	private JLabel title;
	private SearchBar<T> searchBar;
	private JButton searchButton;
	
	private JPanel filtersPanel;
	
	public SearchHeader(String titleText, AbstractSearchKey<T>[] searchKeys) {
		this.hasFilter = false;
		
		basePanel = new JPanel();
		basePanel.setPreferredSize(DEFAULT_SIZE);
		
		basePanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
		
		baseLayout = new BoxLayout(basePanel, BoxLayout.Y_AXIS);
		basePanel.setLayout(baseLayout);
		
		
		addTitle(titleText);
		addSearchTool(searchKeys);
		
		filtersPanel = new JPanel(new GridBagLayout());
		basePanel.add(filtersPanel);
		
	}
	
	public void setTitleTextSize(int size) {
		Font currentFont = title.getFont();
		Font newFont = new Font(currentFont.getFamily(), currentFont.getStyle(), 35);
		title.setFont(newFont);
	}
	
	private void addTitle(String titleText) {
		title = new JLabel(titleText);
		setTitleTextSize(35);
		
		SpringLayout layout = new SpringLayout();
		JPanel panel = new JPanel(layout);
		
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, title, 0, SpringLayout.VERTICAL_CENTER, panel);
		layout.putConstraint(SpringLayout.WEST, title, 30, SpringLayout.WEST, panel);
		panel.add(title);
		
		basePanel.add(panel);
	}
	
	private void addSearchTool(AbstractSearchKey<T>[] searchKeys) {
		int leftPad = 50;
		int rightPad = -50;
		
		searchBar = new SearchBar<T>(searchKeys);
		
		searchButton = new JButton("Pesquisar");
		searchButton.setPreferredSize(new Dimension(220, SearchBar.DEFAULT_SIZE.height));
		
		JPanel sbp = searchBar.getBaseComponent();
		SpringLayout layout = new SpringLayout();
		JPanel panel = new JPanel(layout);
		
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, searchButton, 0, SpringLayout.VERTICAL_CENTER, panel);
		layout.putConstraint(SpringLayout.EAST, searchButton, rightPad, SpringLayout.EAST, panel);
		panel.add(searchButton);
		
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, sbp, 0, SpringLayout.VERTICAL_CENTER, panel);
		layout.putConstraint(SpringLayout.WEST, sbp, leftPad, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.EAST, sbp, rightPad, SpringLayout.WEST, searchButton);
		panel.add(sbp);
		
		basePanel.add(panel);
	}
	
	public void addFilters() {
		
	}
	
	private JPanel createFiltersPanel() {
		//JLabel component = ...
		SpringLayout layout = new SpringLayout();
		JPanel panel = new JPanel(layout);
		
		//layout.putConstraint(SpringLayout.VERTICAL_CENTER, component, 0, SpringLayout.VERTICAL_CENTER, panel);
		//layout.putConstraint(null, component, 0, null, panel);
		
		return panel;
	}
 	
	public boolean hasFilter() {
		return hasFilter;
	}
	
	@Override
	public JPanel getBaseComponent() {
		return basePanel;
	}
	
}
