package petsys;

import javax.swing.SwingUtilities;

import petsys.gui.MainWindow;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			
			MainWindow window = new MainWindow();
			window.run();

		});
	}
}
