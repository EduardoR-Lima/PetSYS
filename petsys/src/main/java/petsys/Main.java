package petsys;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

import petsys.database.ConnectionManager;
import petsys.database.ConnectionManagerImpl;
import petsys.database.daos.ClienteDao;
import petsys.database.models.Cliente;
import petsys.gui.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			
			MainWindow window = new MainWindow();
			window.run();

		});
	}
}
