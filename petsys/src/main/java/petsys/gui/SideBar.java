package petsys.gui;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class SideBar implements CustomPanel {

	private JPanel mainPanel;
	private SpringLayout panelLayout;

	public SideBar() {
		panelLayout = new SpringLayout();
		mainPanel = new JPanel();
		mainPanel.setLayout(panelLayout);

		// Preferred size deve ser restruturado para se adequar ao tamanho da tela
		mainPanel.setPreferredSize(new Dimension(360, 0));

	}

	public void addComponent(JComponent component) {
		Component[] sideBarComponents = mainPanel.getComponents();

		if (sideBarComponents.length == 0) {
			panelLayout.putConstraint(SpringLayout.NORTH, component, SideBarConstants.TOP_PAD, SpringLayout.NORTH,
					mainPanel);
		} else {
			Component northAnchor = sideBarComponents[sideBarComponents.length - 1];
			panelLayout.putConstraint(SpringLayout.NORTH, component, SideBarConstants.BETWEEN_PAD, SpringLayout.SOUTH,
					northAnchor);
		}

		panelLayout.putConstraint(SpringLayout.WEST, component, SideBarConstants.LEFT_PAD, SpringLayout.WEST,
				mainPanel);
		panelLayout.putConstraint(SpringLayout.EAST, component, SideBarConstants.RIGHT_PAD, SpringLayout.EAST,
				mainPanel);

		mainPanel.add(component);
	}

	@Override
	public JPanel getContentPanel() {
		return mainPanel;
	}
}
