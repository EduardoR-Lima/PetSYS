package petsys.gui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class MainWindow {
	
	private JFrame frame;
	private MainWindowPanel mwp;
	
	public MainWindow() {
		frame = new JFrame("Bom dia");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(1200, 700));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

		initMainWindowPanel();
		
		
	
	}
	
	private void initMainWindowPanel() {
		//Criando instância
		mwp = new MainWindowPanel();
		
		CardComponent<JPanel> clientesTest = new CardComponent<>() {
			
			private JPanel p;
			{
				SpringLayout layout = new SpringLayout();
				p = new JPanel(layout);
				
				SearchHeader sh = new SearchHeader("Clientes", new String[]{"CPF", "Nome"});
				JPanel base = sh.getBaseComponent();
				
				layout.putConstraint(SpringLayout.EAST, base, 0, SpringLayout.EAST, p);
				layout.putConstraint(SpringLayout.WEST, base, 0, SpringLayout.WEST, p);
				layout.putConstraint(SpringLayout.NORTH, base, 20, SpringLayout.NORTH, p);
				
				p.add(base);
			}
			
			@Override
			public JPanel getBaseComponent() {
				return p;
			}

			@Override
			public String getCardId() {
				return "cardtest";
			}
		};
		
		JButton bClientes = new MainButton("Clientes").getBaseComponent();
		mwp.addSideBarButton(bClientes);
		mwp.tieButtonTo(bClientes, clientesTest);
		
		JButton bVendas = new MainButton("Vendas").getBaseComponent();
		mwp.addSideBarButton(bVendas);
		//mwp.tieButtonTo(bVendas, ...);
		
		JButton bAtend = new MainButton("Atendimentos").getBaseComponent();
		mwp.addSideBarButton(bAtend);
		//mwp.tieButtonTo(bAtend, ...);
		
		JButton bProdutos = new MainButton("Produtos").getBaseComponent();
		mwp.addSideBarButton(bProdutos);
		//mwp.tieButtonTo(bProdutos, ...);
		
		JButton bServicos = new MainButton("Serviços").getBaseComponent();
		mwp.addSideBarButton(bServicos);
		//mwp.tieButtonTo(bServicos, ...);
		
		//Adicionando ao frame e devolvendo instância
		frame.getContentPane().add(mwp.getBaseComponent());
	}
	
	public void run() {
		frame.setVisible(true);
	}
}
