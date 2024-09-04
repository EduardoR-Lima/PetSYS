package petsys.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindowPanel implements CardComponent<JPanel> {

	private static final String CARD_ID = "cardMainWindow";

	private JPanel basePanel;
	private SideBar sideBar;
	private JPanel workSpace;

	public MainWindowPanel(int sideBarWidth) {
		basePanel = new JPanel();
		basePanel.setLayout(new BorderLayout(0, 0));

		// Criando SideBar
		sideBar = new SideBar(sideBarWidth);
		sideBar.getBaseComponent().setBackground(Color.LIGHT_GRAY); // Temporário
		basePanel.add(sideBar.getBaseComponent(), BorderLayout.WEST);

		
		// Criando workSpace
		workSpace = new JPanel();
		workSpace.setLayout(new CardLayout());
		
		// Panel padrão
		JPanel defaultPanel = new JPanel(new GridBagLayout());
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/icons/logo.png"));
		JLabel logoLabel = new JLabel(logoIcon);
		
		defaultPanel.add(logoLabel);
		
		workSpace.add(defaultPanel, "default");
		
		basePanel.add(workSpace, BorderLayout.CENTER);

	}
	
	public MainWindowPanel() {
		this(SideBar.DEFAULT_SIDEBAR_WIDTH);
	}

	public void addSideBarButton(JButton button) {
		sideBar.addComponent(button);
	}

	public void tieButtonTo(JButton button, CardComponent<JPanel> component) {
		String cardId = component.getCardId();
		JPanel panel = component.getBaseComponent();
		workSpace.add(panel, cardId);
		button.addActionListener(new CallWorkAreaCard(cardId));
	}

	@Override
	public JPanel getBaseComponent() {
		return basePanel;
	}

	@Override
	public String getCardId() {
		return CARD_ID;
	}

	private class CallWorkAreaCard implements ActionListener {

		private String cardId;
		private int state;

		public CallWorkAreaCard(String cardId) {
			this.cardId = cardId;
			this.state = 0;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// wal = work area layout
			CardLayout wal = (CardLayout) workSpace.getLayout();
			
			if (state == 0) {
				wal.show(workSpace, cardId);
			} else {
				wal.show(workSpace, "default");
			}
			
			switchState();
			
		}
		
		private void switchState() {
			if (state == 0) state = 1;
			else state = 0;
		}

	}

}
