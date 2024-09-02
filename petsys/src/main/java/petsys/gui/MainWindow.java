package petsys.gui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class MainWindow {
	
	private JFrame frame;
	
	public MainWindow() {
		frame = new JFrame("Bom dia");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		MainWindowPanel mainPanel = new MainWindowPanel();
		frame.getContentPane().add(mainPanel.getContentPanel());
		
		
	}
	
	
	
	public void run() {
		frame.setVisible(true);
	}
}
