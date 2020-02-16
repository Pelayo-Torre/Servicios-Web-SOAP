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

	/**
	 * Método para añadir un cliente
	 * 
	 * @param client
	 * @return
	 * @throws SQLException
	 * @throws ClientException
	 */
	public String add(Client client) throws SQLException, ClientException {
		clientValidator.validate(client);
		dao = ManagerDAO.getInstance().getClientDAO();
		client.setActive(true);
		return dao.addClient(client);
	}

	/**
	 * Método para borrar un cliente
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws ClientException
	 */
	public String delete(Long id) throws SQLException, ClientException {
		dao = ManagerDAO.getInstance().getClientDAO();

		Client c = dao.listClient(id);
		if (c == null)
			throw new ClientException("El cliente que se desea eliminar no existe", "404");

		return dao.deleteClient(id);
	}

	/**
	 * Método para actualizar el cliente que se pasa por parámetro
	 * 
	 * @param client
	 * @return
	 * @throws SQLException
	 * @throws ClientException
	 */
	public String update(Long id, Client client) throws SQLException, ClientException {
		clientValidator.validate(client);
		dao = ManagerDAO.getInstance().getClientDAO();
		Client c = dao.listClient(id);
		if (c == null)
			throw new ClientException("El cliente que se desea eliminar no existe", "404");
		client.setId(id);
		return dao.updateClient(client);
	}

	/**
	 * Método para obtener el cliente cuyo id se pasa por parámetro
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Client listClient(Long id) throws SQLException {
		dao = ManagerDAO.getInstance().getClientDAO();
		return dao.listClient(id);
	}

	/**
	 * Método para obtener la lista de clientes
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Client> listClients() throws SQLException {
		dao = ManagerDAO.getInstance().getClientDAO();
		return dao.listClients();
	}

}
