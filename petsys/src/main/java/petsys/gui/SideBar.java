package petsys.gui;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class SideBar implements CustomComponent<JPanel> {
	
	public static final int DEFAULT_SIDEBAR_WIDTH = 370;
	public static final int LEFT_PAD = 60;
	public static final int RIGHT_PAD = -60;
	public static final int TOP_PAD = 70;
	public static final int BETWEEN_PAD = 40;
	
	private JPanel basePanel;
	private SpringLayout panelLayout;

	public SideBar(int width) {
		panelLayout = new SpringLayout();
		basePanel = new JPanel();
		basePanel.setLayout(panelLayout);

		// Preferred size deve ser restruturado para se adequar ao tamanho da tela
		basePanel.setPreferredSize(new Dimension(width, 0));
	}

	public void addComponent(JComponent component) {
		Component[] sideBarComponents = basePanel.getComponents();

		if (sideBarComponents.length == 0) {
			panelLayout.putConstraint(SpringLayout.NORTH, component, TOP_PAD, SpringLayout.NORTH,
					basePanel);
		} else {
			Component northAnchor = sideBarComponents[sideBarComponents.length - 1];
			panelLayout.putConstraint(SpringLayout.NORTH, component, BETWEEN_PAD, SpringLayout.SOUTH,
					northAnchor);
		}

		panelLayout.putConstraint(SpringLayout.WEST, component, LEFT_PAD, SpringLayout.WEST,
				basePanel);
		panelLayout.putConstraint(SpringLayout.EAST, component, RIGHT_PAD, SpringLayout.EAST,
				basePanel);

		basePanel.add(component);
	}

	@Override
	public JPanel getBaseComponent() {
		return basePanel;
	}
}
