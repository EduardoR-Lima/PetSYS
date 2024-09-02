package petsys;

import javax.swing.SwingUtilities;

import petsys.gui.MainWindow;

public class Main {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MainWindow window = new MainWindow();
				window.run();
				
			}
		});
	}
}
