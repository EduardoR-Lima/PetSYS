package petsys.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class SearchBar implements CustomComponent<JPanel> {

	public static final Dimension DEFAULT_SIZE = new Dimension(0, 40);

	private static final int TOP_PAD = 4;
	private static final int BOTTOM_PAD = -4;

	private JPanel basePanel;
	private SpringLayout baseLayout;
	private JLabel iconLabel;
	private JTextField textField;
	private JComboBox<String> comboBox;

	@SuppressWarnings("serial")
	public SearchBar(Dimension barSize, String[] searchKeys) {
		baseLayout = new SpringLayout();
		basePanel = new JPanel(baseLayout);
		basePanel.setBackground(Color.WHITE);
		basePanel.setPreferredSize(barSize);
		basePanel.setBorder(new LineBorder(Color.GRAY, 1));
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/icons/loupe.png"));
		iconLabel = new JLabel(icon);
		iconLabel.setPreferredSize(new Dimension(26, 26));
		
		textField = new JTextField();
		textField.setBorder(null);
		
		comboBox = new JComboBox<>(searchKeys);
		comboBox.setPreferredSize(new Dimension(70, 0));
		comboBox.setRenderer(new BasicComboBoxRenderer() {
			{setHorizontalAlignment(CENTER);}
		});
		
		baseLayout.putConstraint(SpringLayout.WEST, iconLabel, 15, SpringLayout.WEST, basePanel);
		baseLayout.putConstraint(SpringLayout.VERTICAL_CENTER, iconLabel, 0, SpringLayout.VERTICAL_CENTER, basePanel);
		basePanel.add(iconLabel);
		
		setVerticalPads(comboBox);
		baseLayout.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, basePanel);
		basePanel.add(comboBox);
		
		setVerticalPads(textField);
		baseLayout.putConstraint(SpringLayout.WEST, textField, 20, SpringLayout.EAST, iconLabel);
		baseLayout.putConstraint(SpringLayout.EAST, textField, -20, SpringLayout.WEST, comboBox);
		basePanel.add(textField);
	}

	public SearchBar(String[] searchKeys) {
		this(DEFAULT_SIZE, searchKeys);
	}

	private void setVerticalPads(JComponent component) {
		baseLayout.putConstraint(SpringLayout.NORTH, component, TOP_PAD, SpringLayout.NORTH, basePanel);
		baseLayout.putConstraint(SpringLayout.SOUTH, component, BOTTOM_PAD, SpringLayout.SOUTH, basePanel);
	}

	public String getSearch() {
		return textField.getText();
	}

	public String getSelectedSearchKey() {
		return (String) comboBox.getSelectedItem();
	}
	
	public void clearSearchText() {
		textField.setText("");
	}

	@Override
	public JPanel getBaseComponent() {
		return basePanel;
	}
	
}
