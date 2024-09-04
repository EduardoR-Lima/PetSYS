package petsys.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import petsys.database.models.Cliente;

public class MainWindow {

	private JFrame frame;
	private MainWindowPanel mwp;

	public MainWindow() {
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

		CardComponent<JPanel> clientesTest = new CardComponent<>() {

			private JPanel p;
			private SearchHeader<Cliente> sh;
			{
				SpringLayout layout = new SpringLayout();
				p = new JPanel(layout);
				

				sh = new SearchHeader<>("Clientes",
						new String[] {"CPF", "Nome"});
				ResultFilter<Cliente> filter = new ResultFilter<>("CPF");
				filter.setSelectionCallBack(e -> {
					System.out.println(e);
				});
				filter.setPopulateEntryHandler(e -> {
					return e.getCpf();
				});
				Cliente cliente = new Cliente();
				cliente.setCpf("08360125341");
				filter.populate(new Cliente[] {cliente});
				ResultFilter<Cliente> filter2 = new ResultFilter<>("Nome");
				ResultFilter[] filters = {filter, filter2};
				sh.addFilters(filters);
				JPanel base = sh.getBaseComponent();

				layout.putConstraint(SpringLayout.EAST, base, 0, SpringLayout.EAST, p);
				layout.putConstraint(SpringLayout.WEST, base, 0, SpringLayout.WEST, p);
				layout.putConstraint(SpringLayout.NORTH, base, 20, SpringLayout.NORTH, p);

				p.add(base);
				
				ResultSpace<Cliente> rs = new ResultSpace<>();
				rs.getBaseComponent().setBackground(Color.RED);
				rs.setHasVisualizeButton(true);
				layout.putConstraint(SpringLayout.NORTH, rs.getBaseComponent(), 0, SpringLayout.SOUTH, base);
				layout.putConstraint(SpringLayout.SOUTH, rs.getBaseComponent(), 0, SpringLayout.SOUTH, p);
				layout.putConstraint(SpringLayout.EAST, rs.getBaseComponent(), 0, SpringLayout.EAST, p);
				layout.putConstraint(SpringLayout.WEST, rs.getBaseComponent(), 0, SpringLayout.WEST, p);
				
				rs.setPopulateEntryHandler(e -> {
					return "%s - %s - %s".formatted(e.getNome(), e.getCpf(), e.getEmail());
				});
				
				p.add(rs.getBaseComponent());
				Cliente cliente1 = new Cliente(1, "08360125341", "Eduardo", "Rua gergelim", "85994361185", "limareduardo@gmail.com", "04092024");
				Cliente cliente2 = new Cliente(1, "08360125341", "Eduarddsddo", "Rua gergelim", "85994361185", "limareduardo@gmail.com", "04092024");
				rs.populate(new Cliente[] {cliente1, cliente2, cliente1, cliente1, cliente1, cliente1, cliente1, cliente1, cliente1, cliente1, cliente1});
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
