package petsys.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class ResultEntry implements CustomComponent<JPanel> {
	
	private Boolean hasButton;
	private JPanel basePanel;
	private SpringLayout baseLayout;
	private JButton bVisualizar;

	public ResultEntry(String text, Boolean hasButton) {
		this.hasButton = false;
		
		baseLayout = new SpringLayout();
		basePanel = new JPanel(baseLayout);
		basePanel.setPreferredSize(new Dimension(0, 50));
		basePanel.setBackground(Color.WHITE);

		JLabel textLabel = new JLabel(text);

		baseLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textLabel, 0, SpringLayout.HORIZONTAL_CENTER,
				basePanel);
		baseLayout.putConstraint(SpringLayout.VERTICAL_CENTER, textLabel, 0, SpringLayout.VERTICAL_CENTER, basePanel);
		basePanel.add(textLabel);
		
		if (hasButton) {
			addButton();
		}
	}
	
	private void addButton() {
		if (hasButton) {
			return;
		}
		
		bVisualizar = new JButton("Visualizar");
		bVisualizar.setOpaque(false);
		bVisualizar.setPreferredSize(new Dimension(170, 0));
		
		baseLayout.putConstraint(SpringLayout.NORTH, bVisualizar, 5, SpringLayout.NORTH, basePanel);
		baseLayout.putConstraint(SpringLayout.SOUTH, bVisualizar, -5, SpringLayout.SOUTH, basePanel);
		baseLayout.putConstraint(SpringLayout.EAST, bVisualizar, -5, SpringLayout.EAST, basePanel);
		
		basePanel.add(bVisualizar);
		this.hasButton = true;
	}

	@Override
	public JPanel getBaseComponent() {
		return basePanel;
	}

}
