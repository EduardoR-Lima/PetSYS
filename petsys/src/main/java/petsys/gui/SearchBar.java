package petsys.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import petsys.database.models.AbstractSearchKey;
import petsys.database.models.Model;

public class SearchBar<T extends Model> implements CustomComponent<JPanel> {

	public static final Dimension DEFAULT_SIZE = new Dimension(0, 40);

	private static final int TOP_PAD = 4;
	private static final int BOTTOM_PAD = -4;

	private JPanel basePanel;
	private SpringLayout baseLayout;
	private JLabel iconLabel;
	private JTextField textField;
	private JComboBox<AbstractSearchKey<T>> comboBox;

	public SearchBar(Dimension barSize, AbstractSearchKey<T>[] searchKeys) {
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
		comboBox.insertItemAt(null, 0);
		comboBox.setSelectedIndex(0);
		comboBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		comboBox.setPreferredSize(new Dimension(70, 0));
		comboBox.setRenderer(new PromptComboBoxRenderer("Key"));
		
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

	public SearchBar(AbstractSearchKey<T>[] searchKeys) {
		this(DEFAULT_SIZE, searchKeys);
	}

	private void setVerticalPads(JComponent component) {
		baseLayout.putConstraint(SpringLayout.NORTH, component, TOP_PAD, SpringLayout.NORTH, basePanel);
		baseLayout.putConstraint(SpringLayout.SOUTH, component, BOTTOM_PAD, SpringLayout.SOUTH, basePanel);
	}

	public String getSearch() {
		return textField.getText();
	}

	@SuppressWarnings("unchecked")
	public AbstractSearchKey<T> getSelectedSearchKey() {
		return (AbstractSearchKey<T>) comboBox.getSelectedItem();
	}

	@Override
	public JPanel getBaseComponent() {
		return basePanel;
	}
	
	@SuppressWarnings("serial")
	private static class PromptComboBoxRenderer extends BasicComboBoxRenderer {
		
		private String prompt;
		
		public PromptComboBoxRenderer(String prompt) {
			super();
			this.prompt = prompt;
			setHorizontalAlignment(CENTER);
		}
		
		@Override
		public Component getListCellRendererComponent(
				JList<?> list, Object value, int index,
				boolean isSelected, boolean cellHasFocus) 
		{
			super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			
			if (value == null) {
				setText("[%s]".formatted(prompt));
			}
			return this;
		}
	}
}
