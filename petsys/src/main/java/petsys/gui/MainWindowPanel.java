package petsys.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class MainWindowPanel implements CustomPanel, CardComponent {
	
	private static final String CARD_ID = "cardMainWindow";
	
	private JPanel mainPanel;
	private SideBar sideBar;
	private JPanel workArea;
	
	
	public MainWindowPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		sideBar = new SideBar();
		sideBar.getContentPanel().setBackground(Color.BLUE); //Temporário
		
		mainPanel.add(sideBar.getContentPanel(), BorderLayout.WEST);	
		
		workArea = new JPanel();
		workArea.setLayout(new CardLayout());
		workArea.setBackground(Color.RED);
		
		mainPanel.add(workArea, BorderLayout.CENTER);
	}
	
	public SideBar getSideBar() {
		return sideBar;
	}
	
	@Override
	public JPanel getContentPanel() {
		return mainPanel;
	}
	
	@Override
	public String getCardId() {
		return CARD_ID;
	}
	
	public static class CallWorkAreaCard implements ActionListener {
		
		private String cardId;
		
		public CallWorkAreaCard(String cardId) {
			this.cardId = cardId;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}

}
