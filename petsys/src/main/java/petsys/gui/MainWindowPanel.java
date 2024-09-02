package petsys.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class MainWindowPanel {
	
	private JPanel mainPanel;
	private JPanel sideBar;
	
	//Paineis a serem adicionados por fora
	private JPanel clientesPanel;
	private JPanel vendasPanel;
	private JPanel atendPanel;
	private JPanel produtosPanel;
	private JPanel servicosPanel;
	
	//Nome dos cards
	private static final String CLIENTES = "cardClientes";
	private static final String VENDAS = "cardVendas";
	private static final String ATENDIMENTOS = "cardAtend";
	private static final String PRODUTOS = "cardProdutos";
	private static final String SERVICOS = "cardServiços";
	
	
	public MainWindowPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		sideBar = new JPanel();
		sideBar.setPreferredSize(new Dimension(370, mainPanel.getHeight()));
		sideBar.setBackground(Color.BLUE);
		sideBar.setLayout(new SpringLayout());
		
		mainPanel.add(sideBar, BorderLayout.WEST);
		
		
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setPreferredSize(new Dimension(0, 60));
		
		sideBar.add(btnNewButton);
		
		
		
		
		
		
		JPanel workArea = new JPanel();
		workArea.setLayout(new CardLayout());
		workArea.setBackground(Color.RED);
		
		mainPanel.add(workArea, BorderLayout.CENTER);
	}
	
	/**
	 * 
	 * Note: This method is not thread safe, call it under SwingUtilities.invokeLater()
	 * 
	 * @param button
	 */
	private void addButtonToSideBar(JButton button) {
		SpringLayout sideBarLayout = (SpringLayout) sideBar.getLayout();
		Component[] sideBarComponents = sideBar.getComponents();
		if (sideBarComponents.length == 0) {
			
		};
		sideBarLayout.putConstraint(SpringLayout.NORTH, button, 70, SpringLayout.NORTH, sideBar);
		sideBarLayout.putConstraint(SpringLayout.WEST, button, 60, SpringLayout.WEST, sideBar);
		sideBarLayout.putConstraint(SpringLayout.EAST, button, -60, SpringLayout.EAST, sideBar);
	}
	
	public JPanel getContentPanel() {
		return mainPanel;
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
