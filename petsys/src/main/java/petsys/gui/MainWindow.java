package petsys.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import petsys.database.models.Cliente;
import petsys.database.services.ModelService;
import petsys.gui.panels.ClientesWorkPanel;
import petsys.gui.panels.VendasWorkPanel;

public class MainWindow {
	
	private ModelService<Cliente> clienteService;
	
	private JFrame frame;
	private MainWindowPanel mwp;

	public MainWindow(ModelService<Cliente> clienteService) {
		this.clienteService = clienteService;
		
		frame = new JFrame("PetSYS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(1200, 700));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		try {
			Image windowIcon = ImageIO.read(getClass().getResource("/images/icons/logo30x30.png"));
			frame.setIconImage(windowIcon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		initMainWindowPanel();

	}

	private void initMainWindowPanel() {
		// Criando instância
		mwp = new MainWindowPanel();

		JButton bClientes = new MainButton("Clientes").getBaseComponent();
		mwp.addSideBarButton(bClientes);
		
		mwp.tieButtonTo(bClientes, new ClientesWorkPanel(clienteService));

		JButton bVendas = new MainButton("Vendas").getBaseComponent();
		mwp.addSideBarButton(bVendas);
		mwp.tieButtonTo(bVendas, new VendasWorkPanel());

		JButton bAtend = new MainButton("Atendimentos").getBaseComponent();
		mwp.addSideBarButton(bAtend);
		// mwp.tieButtonTo(bAtend, ...);

		JButton bProdutos = new MainButton("Produtos").getBaseComponent();
		mwp.addSideBarButton(bProdutos);
		// mwp.tieButtonTo(bProdutos, ...);

		JButton bServicos = new MainButton("Serviços").getBaseComponent();
		mwp.addSideBarButton(bServicos);
		// mwp.tieButtonTo(bServicos, ...);

		// Adicionando ao frame e devolvendo instância
		frame.getContentPane().add(mwp.getBaseComponent());

	}

	public void run() {
		frame.setVisible(true);
	}
}
