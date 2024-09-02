package petsys.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainWindow {
	
	private JFrame frame;
	
	public MainWindow() {
		frame = new JFrame("Bom dia");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		MainWindowPanel mainWindowPanel = new MainWindowPanel();
		
		JButton button = new JButton("Clientes");
		button.setPreferredSize(SideBarConstants.PREFERRED_BUTTON_SIZE);
		mainWindowPanel.getSideBar().addComponent(button);
		
		JButton button2 = new JButton("Vendas");
		button2.setPreferredSize(SideBarConstants.PREFERRED_BUTTON_SIZE);
		mainWindowPanel.getSideBar().addComponent(button2);
		
		frame.getContentPane().add(mainWindowPanel.getContentPanel());
		
		
	}
	
	
	
	public void run() {
		frame.setVisible(true);
	}
}
