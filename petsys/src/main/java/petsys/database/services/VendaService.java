package petsys.database.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import petsys.database.ConnectionManager;
import petsys.database.models.Cliente;
import petsys.database.models.NotaFiscal;
import petsys.database.models.Venda;

public class VendaService {
	private ConnectionManager manager;
	
	public VendaService(ConnectionManager manager) {
		this.manager = manager;
	}
}
