package petsys;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import petsys.database.ConnectionManager;
import petsys.database.ConnectionManagerImpl;
import petsys.database.DbCredentials;
import petsys.database.daos.ClienteDao;
import petsys.database.daos.Dao;
import petsys.database.models.Cliente;
import petsys.database.services.ClienteService;
import petsys.database.services.ModelService;
import petsys.gui.MainWindow;
import petsys.utils.PreferencesManager;

public class Main {

	public static void main(String[] args) {
		
		//DbCredentials dbC = PreferencesManager.getDatabaseCredentials();
		//int option;
		//if (dbC.url() == null || dbC.user() == null || dbC.password() == null) {
		//	option = JOptionPane.showConfirmDialog(null,
		//			"Parece que as credenciais do banco ainda não foram configuradas no sistema. Deseja configurar?",
		//			"Credenciais não encontradas", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		//}
		//JOptionPane.show
		//if (option == JOptionPane.NO_OPTION) {
			
		//}
		
		String fullUrl = "";
		ConnectionManager connManager = new ConnectionManagerImpl(fullUrl, "", "");
		Dao<Cliente> clienteDao = new ClienteDao(connManager);
		ModelService<Cliente> clienteService = new ClienteService(clienteDao);

		SwingUtilities.invokeLater(() -> {

			MainWindow window = new MainWindow(clienteService);
			window.run();

		});
	}
	
	private static void setCredentialsProcess() {
		
	}
}
