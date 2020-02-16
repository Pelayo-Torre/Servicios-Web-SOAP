package services;

import java.sql.SQLException;
import java.util.List;

import exception.ClientException;
import model.Client;
import persistence.ManagerDAO;
import persistence.client.ClientDAO;
import validators.ClientValidator;

public class ClientService {
	
	private ClientDAO dao;
	private ClientValidator clientValidator = new ClientValidator();
	
	public void add(Client client) throws SQLException, ClientException {
		clientValidator.validate(client);
		dao = new ManagerDAO().getClientDAO();
		dao.addClient(client);
	}
	
	public void delete(Long id) throws SQLException, ClientException {
		dao = new ManagerDAO().getClientDAO();
		
		Client c = dao.getClient(id);
		if(c == null)
			throw new ClientException("El cliente que se desea eliminar no existe", "404");
		
		dao.deleteClient(id);
	}
	
	public Client getClient(Long id) throws SQLException {
		dao = new ManagerDAO().getClientDAO();
		return dao.getClient(id);
	}
	
	public void update(Client client) throws SQLException, ClientException {
		clientValidator.validate(client);
		dao = new ManagerDAO().getClientDAO();
	
		Client c = dao.getClient(client.getId());
		if(c == null)
			throw new ClientException("El cliente que se desea eliminar no existe", "404");
		
		dao.updateClient(client);
	}
	
	public List<Client> listClients() throws SQLException{
		dao = new ManagerDAO().getClientDAO();
		return dao.getClients();
	}

}
